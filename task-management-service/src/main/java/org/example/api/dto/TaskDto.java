package org.example.api.dto;

import org.example.enums.TaskPriorityType;
import org.example.enums.TaskStatusType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record TaskDto(
        UUID id,

        String title,
        String description,
        String comment,

        TaskStatusType status,
        TaskPriorityType priority,

        UUID assigner,
        List<UUID> assignees,
        List<CommentDto> comments,
        Instant created
) {
}
