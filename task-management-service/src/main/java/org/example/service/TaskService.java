package org.example.service;

import org.example.api.dto.EmployeeDto;
import org.example.api.dto.TaskDto;
import org.example.api.query.TaskQueryParams;
import org.example.api.request.CreateTaskRequest;
import org.example.api.request.MultiIdRequest;
import org.example.enums.TaskStatusType;
import org.example.jpa.domain.DbId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface TaskService {

    @NonNull
    Page<TaskDto> taskList(@NonNull Pageable pageable, @NonNull TaskQueryParams queryParams);

    @NonNull
    DbId<UUID> createTask(@NonNull CreateTaskRequest createTaskRequest);

    @NonNull
    TaskDto getTaskById(@NonNull UUID id);

    void updateTask(@NonNull TaskDto taskDto);

    void updateTaskStatus(@NonNull UUID id, @NonNull TaskStatusType status);

    void deleteTasks(@NonNull MultiIdRequest<UUID> multiIdRequest);
}
