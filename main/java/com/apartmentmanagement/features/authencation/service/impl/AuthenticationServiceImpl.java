package com.apartmentmanagement.features.authencation.service.impl;

import com.apartmentmanagement.common.exception.ApartmentManagementException;
import com.apartmentmanagement.common.exception.ErrorCode;
import com.apartmentmanagement.features.authencation.converter.AccountConverter;
import com.apartmentmanagement.features.authencation.domain.Account;
import com.apartmentmanagement.features.authencation.domain.dto.LoginRequest;
import com.apartmentmanagement.features.authencation.domain.dto.RegisterRequest;
import com.apartmentmanagement.features.authencation.mapper.AccountMapper;
import com.apartmentmanagement.features.authencation.service.AuthenticationService;
import com.apartmentmanagement.features.authencation.service.JwtService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountConverter accountConverter;
    private final JwtService jwtService;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(RegisterRequest registerRequest) {
        if(accountMapper.validationAccount(registerRequest) != null)
            throw new ApartmentManagementException(ErrorCode.AUTH_01);
        String passwordHash = passwordEncoder.encode(registerRequest.getPassword());
        registerRequest.setPassword(passwordHash);
        accountMapper.insertAccount(accountConverter.toAccount(registerRequest));
    }

    @Override
    public String login(LoginRequest loginRequest) throws JOSEException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        Account account = (Account) authentication.getPrincipal();
        return jwtService.generateAccessToken(account);
    }
}
