package org.example.security.impl;

import lombok.RequiredArgsConstructor;
import org.example.repository.TaskRepository;
import org.example.security.AuthorizationService;
import org.example.security.EmployeePrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service("authorizationService")
@RequiredArgsConstructor
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    private final TaskRepository taskRepository;
    private final EmployeePrincipal employeePrincipal;

    @Override
    public boolean isTaskOwner(UUID taskId) {
        return taskRepository.isTaskOwner(taskId, employeePrincipal.getUser().getId());
    }
}