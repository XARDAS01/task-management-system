package org.example.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;
import java.util.UUID;

/**
 * Represents a reference object with an ID, name, and optional metadata.
 */
@Schema(description = "A data transfer object (DTO) representing a reference object with an ID, name, and optional metadata.")
public record ReferenceDto(

        @Schema(
                description = "The unique identifier of the reference.",
                example = "123e4567-e89b-12d3-a456-426614174000",
                nullable = true
        )
        UUID id,

        @Schema(
                description = "The name of the reference.",
                example = "Sample Reference",
                nullable = true
        )
        String name,

        @Schema(
                description = "A map of key-value pairs representing additional metadata about the reference.",
                example = "{\"key1\": \"value1\", \"key2\": \"value2\"}",
                nullable = true
        )
        Map<String, String> metadata
) {

    /**
     * Creates a ReferenceDto with only the ID.
     *
     * @param id The unique identifier of the reference.
     * @return A ReferenceDto instance with the specified ID.
     */
    @Schema(description = "Creates a ReferenceDto with only the ID.")
    public static ReferenceDto of(UUID id) {
        return new ReferenceDto(id, null, null);
    }

    /**
     * Creates a ReferenceDto with the ID and name.
     *
     * @param id   The unique identifier of the reference.
     * @param name The name of the reference.
     * @return A ReferenceDto instance with the specified ID and name.
     */
    @Schema(description = "Creates a ReferenceDto with the ID and name.")
    public static ReferenceDto of(UUID id, String name) {
        return new ReferenceDto(id, name, null);
    }

    /**
     * Creates a ReferenceDto with only the name.
     *
     * @param name The name of the reference.
     * @return A ReferenceDto instance with the specified name.
     */
    @Schema(description = "Creates a ReferenceDto with only the name.")
    public static ReferenceDto of(String name) {
        return new ReferenceDto(null, name, null);
    }
}
