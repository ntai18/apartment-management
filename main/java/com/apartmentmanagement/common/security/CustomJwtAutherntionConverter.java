package com.apartmentmanagement.common.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomJwtAutherntionConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Long userId = jwt.getClaim("id");
        Collection<String> role = jwt.getClaim("role");
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (role != null)
            authorities = role.stream().map(SimpleGrantedAuthority::new).toList();
        UserInformation userInformation = new UserInformation();
        userInformation.setUserId(userId);
        return new UsernamePasswordAuthenticationToken(userInformation, jwt, authorities);
    }
}
