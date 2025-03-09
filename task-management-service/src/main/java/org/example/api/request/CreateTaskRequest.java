package org.example.api.request;

import org.example.enums.TaskPriorityType;

public record CreateTaskRequest(
        String title,
        String description,
        String comment,

        TaskPriorityType priority
) {
}
