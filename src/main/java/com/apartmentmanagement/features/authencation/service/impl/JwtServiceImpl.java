package com.apartmentmanagement.features.authencation.service.impl;

import com.apartmentmanagement.features.authencation.domain.Account;
import com.apartmentmanagement.features.authencation.service.JwtService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Override
    public String generateAccessToken(Account user) throws JOSEException {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        Date now = new Date();
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .issuer("am.tai")
                .issueTime(now)
                .subject(user.getUsername())
                .expirationTime(Date.from(now.toInstant().plus(50, ChronoUnit.MINUTES)))
                .claim("id", user.getId())
                .claim("role", user.getAuthorities().stream().map(GrantedAuthority::getAuthority))
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        jwsObject.sign(new MACSigner(secretKey));
        return jwsObject.serialize();
    }

    @Override
    public boolean verifyAccessToken(String accessToken) throws JOSEException, ParseException {
        SignedJWT signedJWT = SignedJWT.parse(accessToken);
        Date expiration = signedJWT.getJWTClaimsSet().getExpirationTime();
        if (expiration.before(new Date())) {
            return false;
        }
        return signedJWT.verify(new MACVerifier(secretKey));
    }
}
