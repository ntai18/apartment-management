package com.apartmentmanagement.features.profile.service.impl;

import com.apartmentmanagement.common.exception.ApartmentManagementException;
import com.apartmentmanagement.common.exception.ErrorCode;
import com.apartmentmanagement.features.profile.converter.ProfileConverter;
import com.apartmentmanagement.features.profile.domain.dto.ProfileRequest;
import com.apartmentmanagement.features.profile.domain.dto.ProfileResponse;
import com.apartmentmanagement.features.profile.mapper.ProfileMapper;
import com.apartmentmanagement.features.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileMapper profileMapper;
    private final ProfileConverter profileConverter;

    @Override
    public void createProfile(ProfileRequest profileRequest, Long accountId) {
        if (validateProfile(accountId))
            throw new ApartmentManagementException(ErrorCode.AUTH_01);
        profileMapper.createProfile(profileRequest, accountId);
    }

    @Override
    public ProfileResponse getProfile(Long accountId) {
        log.info("Get Profile Response");
        if (!(validateProfile(accountId)))
            throw new ApartmentManagementException(ErrorCode.AUTH_01);
        return profileConverter.profileToProfileResponse(profileMapper.getProfile(accountId));
    }

    @Override
    public void updateProfile(Long accountId, ProfileRequest profileRequest) {
        if (!(validateProfile(accountId)))
            throw new ApartmentManagementException(ErrorCode.AUTH_01);
        profileMapper.updateProfile(profileRequest, accountId);
    }

    private boolean validateProfile(Long accountId) {
        return profileMapper.isValidation(accountId) != null;
    }
}
