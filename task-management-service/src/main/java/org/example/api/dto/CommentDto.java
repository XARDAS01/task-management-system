package org.example.api.dto;

import java.time.Instant;
import java.util.UUID;

public record CommentDto(
        UUID id,
        String text,
        UUID employee,
        Instant created
) {
}
