package com.apartmentmanagement.features.authencation.controller;

import com.apartmentmanagement.common.exception.ApiResponse;
import com.apartmentmanagement.features.authencation.domain.dto.LoginRequest;
import com.apartmentmanagement.features.authencation.domain.dto.RegisterRequest;
import com.apartmentmanagement.features.authencation.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        authenticationService.register(registerRequest);
        return ResponseEntity.ok().body(ApiResponse.success("Register Successfully!"));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@Valid @RequestBody LoginRequest loginRequest) throws JOSEException {
        return ResponseEntity.ok().body(ApiResponse.successMessData("Login Successfully!", authenticationService.login(loginRequest)));
    }
}
