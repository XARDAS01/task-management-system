package org.example.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.enums.TaskPriorityType;
import org.example.enums.TaskStatusType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Represents a task with its associated details.
 */
@Schema(description = "A data transfer object (DTO) representing a task with its associated details.")
public record TaskDto(

        @Schema(
                description = "The unique identifier of the task.",
                example = "123e4567-e89b-12d3-a456-426614174000"
        )
        UUID id,

        @Schema(
                description = "The title of the task.",
                example = "Complete project documentation"
        )
        String title,

        @Schema(
                description = "The detailed description of the task.",
                example = "Write and review the documentation for the new API endpoints."
        )
        String description,

        @Schema(
                description = "A comment or note associated with the task.",
                example = "This task is high priority.",
                nullable = true
        )
        String comment,

        @Schema(
                description = "The current status of the task.",
                implementation = TaskStatusType.class
        )
        TaskStatusType status,

        @Schema(
                description = "The priority level of the task.",
                implementation = TaskPriorityType.class
        )
        TaskPriorityType priority,

        @Schema(
                description = "The unique identifier of the user who assigned the task.",
                example = "123e4567-e89b-12d3-a456-426614174000"
        )
        UUID assigner,

        @Schema(
                description = "A list of unique identifiers of users assigned to the task.",
                example = "[\"123e4567-e89b-12d3-a456-426614174000\", \"123e4567-e89b-12d3-a456-426614174001\"]"
        )
        List<UUID> assignees,

        @Schema(
                description = "A list of comments associated with the task.",
                example = "[]"
        )
        List<CommentDto> comments,

        @Schema(
                description = "The timestamp when the task was created.",
                example = "2023-10-01T12:34:56.789Z"
        )
        Instant created
) {
}
