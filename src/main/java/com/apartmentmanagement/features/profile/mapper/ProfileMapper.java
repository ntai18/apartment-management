package com.apartmentmanagement.features.profile.mapper;

import com.apartmentmanagement.features.profile.domain.Profile;
import com.apartmentmanagement.features.profile.domain.dto.ProfileRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileMapper {
    void createProfile(ProfileRequest profileRequest, Long accountId);

    Profile isValidation(Long accountId);

    Profile getProfile(Long accountId);

    void updateProfile(ProfileRequest profileRequest, Long accountId);
}
