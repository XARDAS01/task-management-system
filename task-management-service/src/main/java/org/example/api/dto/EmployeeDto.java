package org.example.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Represents an employee and their associated data.
 */
@Schema(description = "A data transfer object (DTO) representing an employee and their associated information.")
public record EmployeeDto(

        @Schema(
                description = "The unique identifier of the employee.",
                example = "123e4567-e89b-12d3-a456-426614174000"
        )
        UUID id,

        @Schema(
                description = "The user information associated with the employee.",
                implementation = UserInfoDto.class
        )
        UserInfoDto userInfo,

        @Schema(
                description = "A list of tasks assigned by this employee to others.",
                example = "[]"
        )
        List<TaskDto> tasksAssignedByMe,

        @Schema(
                description = "A set of tasks assigned to this employee by others.",
                example = "[]"
        )
        Set<TaskDto> tasksAssignedToMe,

        @Schema(
                description = "A set of comments written by this employee.",
                example = "[]"
        )
        Set<CommentDto> commentsWrittenByMe,

        @Schema(
                description = "The timestamp when the employee record was created.",
                example = "2023-10-01T12:34:56.789Z"
        )
        Instant created
) {
}
