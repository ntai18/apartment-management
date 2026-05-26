package com.apartmentmanagement.features.authencation.converter;

import com.apartmentmanagement.features.authencation.domain.Account;
import com.apartmentmanagement.features.authencation.domain.dto.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountConverter {
    Account toAccount(RegisterRequest registerRequest);
}
