package org.example.api.request;

import org.example.enums.UserRole;

public record SignUpRequest(
        String username,
        String password,
        UserRole role
) {
}
