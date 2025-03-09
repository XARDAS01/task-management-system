package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.api.dto.TaskDto;
import org.example.api.request.CreateTaskRequest;
import org.example.api.request.MultiIdRequest;
import org.example.enums.TaskStatusType;
import org.example.exception.ObjectNotFoundException;
import org.example.jpa.domain.DbId;
import org.example.mapper.TaskMapper;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.example.security.EmployeePrincipal;
import org.example.service.TaskService;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final EmployeePrincipal employeePrincipal;

    @PreAuthorize("hasAuthority('ADMIN')")
    @NonNull
    @Override
    public DbId<UUID> createTask(@NonNull CreateTaskRequest createTaskRequest) {
        return taskRepository.save(
                taskMapper.mapToEntity(createTaskRequest, employeePrincipal.getUser()));
    }

    @NonNull
    @Override
    public TaskDto getTaskById(@NonNull UUID id) {
        return taskRepository.findById(id).map(taskMapper::mapToDto)
                .orElseThrow(() -> new ObjectNotFoundException(Task.class));
    }

    @PreAuthorize("hasAuthority('ADMIN') or @authorizationService.isTaskOwner(#taskDto.id())")
    @Override
    public void updateTask(@NonNull TaskDto taskDto) {
        taskRepository.findById(taskDto.id()).ifPresentOrElse(task -> {
            taskMapper.update(task, taskDto);
        }, () -> {
            log.info("Update task error!");
        });
    }

    @PreAuthorize("hasAuthority('ADMIN') or @authorizationService.isTaskOwner(#id)")
    @Override
    public void updateTaskStatus(@NonNull UUID id, @NonNull TaskStatusType status) {
        taskRepository.changeTaskStatus(id, status);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public void deleteTasks(@NonNull MultiIdRequest<UUID> multiIdRequest) {
        taskRepository.deleteAllById(multiIdRequest.data());
    }
}
