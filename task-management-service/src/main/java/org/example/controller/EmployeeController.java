package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.api.dto.EmployeeDto;
import org.example.service.EmployeeService;
import org.springframework.data.domain.Pageable;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public record EmployeeController(EmployeeService employeeService) {

    @GetMapping
    @Operation(summary = "${employee.list}", responses = @ApiResponse(responseCode = "200"))
    @PageableAsQueryParam
    public ResponseEntity<Page<EmployeeDto>> employeeList(@Parameter(hidden = true) Pageable pageable) {
        return ResponseEntity.ok().body(employeeService.employeeList(pageable));
    }

    @PostMapping("/{employeeId}/assign/{taskId}")
    @Operation(summary = "${employee.assign}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> assign(@PathVariable UUID employeeId, @PathVariable UUID taskId) {
        employeeService.assign(employeeId, taskId);
        return ResponseEntity.noContent().build();
    }
}
