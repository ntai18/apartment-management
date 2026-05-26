package com.apartmentmanagement.features.authencation.mapper;

import com.apartmentmanagement.features.authencation.domain.Account;
import com.apartmentmanagement.features.authencation.domain.dto.RegisterRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    void insertAccount(Account account);
    Account findAccountByUsername(String username);
    Account validationAccount(RegisterRequest registerRequest);

}
