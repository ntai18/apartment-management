package com.apartmentmanagement.features.authencation.domain;

import com.apartmentmanagement.common.type.Role;
import com.apartmentmanagement.common.type.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class Account implements UserDetails {
    private Long id;
    private String email;
    private String phone;
    private String username;
    private String password;
    private Role role;
    private Status status;
    private Timestamp createAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }
}
