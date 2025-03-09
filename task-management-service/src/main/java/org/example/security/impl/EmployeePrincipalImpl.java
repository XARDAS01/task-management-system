package org.example.security.impl;

import lombok.RequiredArgsConstructor;
import org.example.exception.ObjectNotFoundException;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.security.EmployeePrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeePrincipalImpl implements EmployeePrincipal {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getUser() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();

        return employeeRepository.findEmployeeByUsername((String) authentication.getPrincipal())
                .orElseThrow(() -> new ObjectNotFoundException(Employee.class));
    }
}
