package com.apartmentmanagement.features.profile.controller;

import com.apartmentmanagement.common.exception.ApiResponse;
import com.apartmentmanagement.common.security.UserInformation;
import com.apartmentmanagement.features.profile.domain.dto.ProfileRequest;
import com.apartmentmanagement.features.profile.domain.dto.ProfileResponse;
import com.apartmentmanagement.features.profile.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/profiles")
    public ResponseEntity<ApiResponse> createProfile(@Valid @RequestBody ProfileRequest profileRequest, @AuthenticationPrincipal UserInformation userInformation) {
        profileService.createProfile(profileRequest, userInformation.getUserId());
        return ResponseEntity.ok().body(ApiResponse.success("Profile created successfully"));
    }

    @PutMapping("/profiles")
    public ResponseEntity<ApiResponse> updateProfile(@Valid @RequestBody ProfileRequest profileRequest, @AuthenticationPrincipal UserInformation userInformation) {
        profileService.updateProfile(userInformation.getUserId(), profileRequest);
        return ResponseEntity.ok().body(ApiResponse.success("Profile created successfully"));
    }

    @GetMapping("/profiles")
    public ResponseEntity<ApiResponse<ProfileResponse>> getProfile(@AuthenticationPrincipal UserInformation userInformation) {
        return ResponseEntity.ok().body(ApiResponse.successData(profileService.getProfile(userInformation.getUserId())));
    }


}
