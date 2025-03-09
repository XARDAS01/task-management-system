package org.example.service;

import org.example.api.request.SignInRequest;
import org.example.api.request.SignUpRequest;
import org.springframework.lang.NonNull;

public interface AuthService {

    @NonNull
    String signUp(@NonNull SignUpRequest request);

    @NonNull
    String signIn(@NonNull SignInRequest request);
}
