package com.apartmentmanagement.features.profile.service;

import com.apartmentmanagement.features.profile.domain.dto.ProfileRequest;
import com.apartmentmanagement.features.profile.domain.dto.ProfileResponse;

public interface ProfileService {
    void createProfile(ProfileRequest profileRequest, Long accountId);

    ProfileResponse getProfile(Long accountId);

    void updateProfile(Long accountId, ProfileRequest profileRequest);

}
