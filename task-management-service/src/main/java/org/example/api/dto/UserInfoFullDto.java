package org.example.api.dto;

import org.example.enums.UserRole;

public record UserInfoFullDto(
        String username,
        String password,
        UserRole role,

        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired,
        boolean enabled
) {
}
