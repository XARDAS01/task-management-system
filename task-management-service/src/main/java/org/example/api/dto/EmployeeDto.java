package org.example.api.dto;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record EmployeeDto(
        UUID id,

        UserInfoDto userInfo,

        List<TaskDto> tasksAssignedByMe,
        Set<TaskDto> tasksAssignedToMe,
        Set<CommentDto> commentsWrittenByMe,
        Instant created
) {
}
