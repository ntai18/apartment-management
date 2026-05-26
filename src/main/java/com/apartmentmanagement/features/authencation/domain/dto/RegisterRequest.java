package com.apartmentmanagement.features.authencation.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @Email(message = "false format!!")
    private String email;
    @Size(min = 9, max = 11, message = "> 9 and < 12")
    private String phone;
    private String username;
    private String password;
}
