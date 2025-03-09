package org.example.service;

import org.example.api.dto.EmployeeDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    @NonNull
    Page<EmployeeDto> employeeList(@NonNull Pageable pageable);

    void assign(@NonNull UUID employeeId, @NonNull UUID taskId);
}
