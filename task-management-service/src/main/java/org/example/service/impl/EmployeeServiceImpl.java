package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.api.dto.EmployeeDto;
import org.example.exception.ObjectNotFoundException;
import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.example.model.Task;
import org.example.repository.EmployeeRepository;
import org.example.repository.TaskRepository;
import org.example.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {

    private final TaskRepository taskRepository;
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public Page<EmployeeDto> employeeList(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(employeeMapper::mapToDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public void assign(@NonNull UUID employeeId, @NonNull UUID taskId) {
        final var employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ObjectNotFoundException(Employee.class));
        final var task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ObjectNotFoundException(Task.class));

        log.info("New assign task: {}", task.getId());
        task.getAssignees().add(employee);
    }
}
