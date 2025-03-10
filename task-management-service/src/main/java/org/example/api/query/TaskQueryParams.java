package org.example.api.query;

import java.util.UUID;

public record TaskQueryParams(
        UUID assignEmployeeId,
        String title
) {
}
