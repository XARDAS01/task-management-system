package org.example.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.example.enums.UserRole;

/**
 * Represents a request for user registration (sign-up).
 */
@Schema(description = "A data transfer object (DTO) representing a request for user registration (sign-up).")
public record SignUpRequest(

        @NotNull(message = "Username cannot be null")
        @Email(message = "Email should be valid")
        @Schema(
                description = "The username of the user.",
                example = "john.doe@yandex.ru"
        )
        String username,

        @NotNull(message = "Password cannot be null")
        @Schema(
                description = "The password of the user. This field is sensitive and should be handled securely.",
                example = "securePassword123!",
                accessMode = Schema.AccessMode.WRITE_ONLY
        )
        String password,

        @NotNull(message = "Role cannot be null")
        @Schema(
                description = "The role of the user.",
                implementation = UserRole.class
        )
        UserRole role
) {
}
