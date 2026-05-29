package com.apartmentmanagement.features.profile.converter;

import com.apartmentmanagement.features.profile.domain.Profile;
import com.apartmentmanagement.features.profile.domain.dto.ProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileConverter {
    ProfileResponse profileToProfileResponse(Profile profile);
}
