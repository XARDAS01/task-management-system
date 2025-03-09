package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.example.api.dto.ReferenceDto;
import org.example.api.request.SignInRequest;
import org.example.api.request.SignUpRequest;
import org.example.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public record AuthController(AuthService authService) {

    @PostMapping("/login")
    @Operation(summary = "${auth.signIn}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<ReferenceDto> signIn(@RequestBody @Valid SignInRequest request) {
        return ResponseEntity.ok().body(ReferenceDto.of(null, authService.signIn(request)));
    }

    @PostMapping("/registration")
    @Operation(summary = "${auth.signUp}", responses = @ApiResponse(responseCode = "201"))
    public ResponseEntity<ReferenceDto> signUp(@RequestBody @Valid SignUpRequest request) {
        return ResponseEntity.ok().body(ReferenceDto.of(authService.signUp(request)));
    }
}
