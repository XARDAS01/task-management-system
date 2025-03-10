package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.example.api.dto.EmployeeDto;
import org.example.api.dto.ReferenceDto;
import org.example.api.dto.TaskDto;
import org.example.api.query.TaskQueryParams;
import org.example.api.request.CreateTaskRequest;
import org.example.api.request.MultiIdRequest;
import org.example.enums.TaskStatusType;
import org.example.service.TaskService;
import org.springdoc.core.annotations.ParameterObject;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task")
public record TaskController(TaskService taskService) {

    @GetMapping
    @Operation(summary = "${task.page}", responses = @ApiResponse(responseCode = "200"))
    @PageableAsQueryParam
    public ResponseEntity<Page<TaskDto>> employeeList(@Parameter(hidden = true) Pageable pageable,
                                                          @ParameterObject TaskQueryParams queryParams) {
        return ResponseEntity.ok().body(taskService.taskList(pageable, queryParams));
    }

    @PostMapping("/create")
    @Operation(summary = "${task.create}", responses = @ApiResponse(responseCode = "201"))
    public ResponseEntity<ReferenceDto> createTask(@RequestBody @Valid CreateTaskRequest createTaskRequest) {
        final var next = taskService.createTask(createTaskRequest);
        return ResponseEntity.created(URI.create("http://localhost:8081/api/v1/task/" + next.getId()))
                .body(ReferenceDto.of(next.getId()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "${task.getById}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<TaskDto> tasks(@PathVariable UUID id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PutMapping
    @Operation(summary = "${task.update}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> taskUpdate(@RequestBody @Valid TaskDto taskDto) {
        taskService.updateTask(taskDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "${task.update}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> taskUpdateStatus(@PathVariable UUID id, @RequestBody TaskStatusType status) {
        taskService.updateTaskStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "${task.delete}", responses = @ApiResponse(responseCode = "204"))
    public ResponseEntity<Void> taskDelete(@RequestBody @Valid MultiIdRequest<UUID>  multiIdRequest) {
        taskService.deleteTasks(multiIdRequest);
        return ResponseEntity.noContent().build();
    }
}
