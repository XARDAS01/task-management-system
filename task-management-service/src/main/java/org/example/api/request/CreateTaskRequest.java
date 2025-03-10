package org.example.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.example.enums.TaskPriorityType;

/**
 * Represents a request to create a new task.
 */
@Schema(description = "A data transfer object (DTO) representing a request to create a new task.")
public record CreateTaskRequest(

        @NotNull(message = "Title cannot be null")
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
                description = "An optional comment or note associated with the task.",
                example = "This task is high priority."
        )
        String comment,

        @NotNull(message = "Priority cannot be null")
        @Schema(
                description = "The priority level of the task.",
                implementation = TaskPriorityType.class
        )
        TaskPriorityType priority
) {
}
