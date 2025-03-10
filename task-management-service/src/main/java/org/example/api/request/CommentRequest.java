package org.example.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * Represents a request to create or update a comment on a task.
 */
@Schema(description = "A data transfer object (DTO) representing a request to create or update a comment on a task.")
public record CommentRequest(

        @NotNull(message = "TaskId cannot be null")
        @Schema(
                description = "The unique identifier of the task to which the comment belongs.",
                example = "123e4567-e89b-12d3-a456-426614174000"
        )
        UUID taskId,

        @NotNull(message = "Text cannot be null")
        @Schema(
                description = "The text content of the comment.",
                example = "This task needs more attention."
        )
        String text
) {
}
