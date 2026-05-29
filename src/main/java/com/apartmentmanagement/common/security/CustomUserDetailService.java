package com.apartmentmanagement.common.security;

import com.apartmentmanagement.features.authencation.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accountMapper.findAccountByUsername(username));
            System.out.println("====== DỮ LIỆU ACCOUNT ======");
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountMapper.findAccountByUsername(username);
    }
}
