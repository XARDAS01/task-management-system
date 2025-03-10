package org.example.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents a comment made by an employee.
 */
@Schema(description = "A data transfer object (DTO) representing a comment made by an employee.")
public record CommentDto(

        @Schema(
                description = "The unique identifier of the comment.",
                example = "123e4567-e89b-12d3-a456-426614174000"
        )
        UUID id,

        @NotNull(message = "Text cannot be null")
        @Schema(
                description = "The text content of the comment.",
                example = "This is a sample comment."
        )
        String text,

        @Schema(
                description = "The unique identifier of the employee who made the comment.",
                example = "123e4567-e89b-12d3-a456-426614174000"
        )
        UUID employee,

        @Schema(
                description = "The timestamp when the comment was created.",
                example = "2023-10-01T12:34:56.789Z"
        )
        Instant created
) {
}
