package org.example.api.request;

import java.util.UUID;

public record CommentRequest(
        UUID taskId,
        String text
) {
}
