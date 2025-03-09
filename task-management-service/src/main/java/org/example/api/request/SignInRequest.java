package org.example.api.request;

public record SignInRequest(
        String username,
        String password
) {
}
