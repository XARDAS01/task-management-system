package org.example.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.enums.UserRole;

/**
 * Represents full user information, including sensitive details like password, roles, and account status.
 */
@Schema(description = "A data transfer object (DTO) representing full user information, including sensitive details like password, roles, and account status.")
public record UserInfoFullDto(
        @Schema(
                description = "The username of the user.",
                example = "john.doe"
        )
        String username,

        @Schema(
                description = "The password of the user. This field is sensitive and should be handled securely.",
                example = "securePassword123!",
                accessMode = Schema.AccessMode.WRITE_ONLY
        )
        String password,

        @Schema(
                description = "The role of the user.",
                implementation = UserRole.class
        )
        UserRole role,

        @Schema(
                description = "Indicates whether the user's account is non-expired.",
                example = "true"
        )
        boolean accountNonExpired,

        @Schema(
                description = "Indicates whether the user's account is non-locked.",
                example = "true"
        )
        boolean accountNonLocked,

        @Schema(
                description = "Indicates whether the user's credentials are non-expired.",
                example = "true"
        )
        boolean credentialsNonExpired,

        @Schema(
                description = "Indicates whether the user's account is enabled.",
                example = "true"
        )
        boolean enabled
) {
}
