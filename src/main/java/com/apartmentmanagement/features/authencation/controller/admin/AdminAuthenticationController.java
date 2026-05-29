package com.apartmentmanagement.features.authencation.controller.admin;

import com.apartmentmanagement.common.exception.ApiResponse;
import com.apartmentmanagement.features.authencation.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminAuthenticationController {
    private final AuthenticationService authenticationService;

    @DeleteMapping("/account/{account-id}")
    public ResponseEntity<ApiResponse> softDeleteAccount(@PathVariable("account-id") Long accountId) {
        authenticationService.deleteAccount(accountId);
        return ResponseEntity.ok().body(ApiResponse.success("Account deleted successfully" + accountId));
    }

    @PostMapping("/account/{account-id}")
    public ResponseEntity<ApiResponse> softBanedAccount(@PathVariable("account-id") Long accountId) {
        authenticationService.banedAccount(accountId);
        return ResponseEntity.ok().body(ApiResponse.success("Account baned successfully" + accountId));
    }

    @PostMapping("/account/active/{account-id}")
    public ResponseEntity<ApiResponse> unBanedAccount(@PathVariable("account-id") Long accountId) {
        authenticationService.unBanedAccount(accountId);
        return ResponseEntity.ok().body(ApiResponse.success("Account unbaned successfully" + accountId));
    }

}
