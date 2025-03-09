package org.example.api.dto;

import org.example.enums.UserRole;

public record UserInfoDto(
        String username,
        UserRole role,

        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired,
        boolean enabled
) {
}
