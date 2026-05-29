package com.apartmentmanagement.features.authencation.service;

import com.apartmentmanagement.features.authencation.domain.dto.LoginRequest;
import com.apartmentmanagement.features.authencation.domain.dto.RegisterRequest;
import com.nimbusds.jose.JOSEException;

public interface AuthenticationService {
    void register(RegisterRequest registerRequest);

    String login(LoginRequest loginRequest) throws JOSEException;

    void deleteAccount(Long accountId);

    void banedAccount(Long accountId);

    void unBanedAccount(Long accountId);
}
