package com.apartmentmanagement.features.authencation.domain.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
}
