package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.api.request.CommentRequest;
import org.example.exception.ObjectNotFoundException;
import org.example.jpa.domain.DbId;
import org.example.mapper.CommentMapper;
import org.example.model.Task;
import org.example.repository.CommentRepository;
import org.example.repository.TaskRepository;
import org.example.security.EmployeePrincipal;
import org.example.service.CommentService;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class CommentServiceImpl implements CommentService {

    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final EmployeePrincipal employeePrincipal;

    @PreAuthorize("hasAuthority('ADMIN') or @authorizationService.isTaskOwner(#commentRequest.taskId())")
    @NonNull
    @Override
    public DbId<UUID> comment(@NonNull CommentRequest commentRequest) {
        final var employee = employeePrincipal.getUser();
        final var task = taskRepository.findById(commentRequest.taskId())
                .orElseThrow(() -> new ObjectNotFoundException(Task.class));

        log.info("New comment on task: {}", commentRequest.taskId());
        return commentRepository.save(commentMapper.mapToEntity(commentRequest.text(), task, employee));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public void delete(@NonNull UUID id) {
        log.info("Comment delete: {}", id);
        commentRepository.deleteById(id);
    }
}
