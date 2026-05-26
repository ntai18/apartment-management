package com.apartmentmanagement.features.authencation.service;

import com.apartmentmanagement.features.authencation.domain.Account;
import com.nimbusds.jose.*;
import java.text.ParseException;

public interface JwtService {
    String generateAccessToken(Account account) throws JOSEException;

    boolean verifyAccessToken(String accessToken) throws JOSEException, ParseException;// thừa vì hàm nimbusJwtdecoder.decode(token), cũng tự ktra time và chữ kí
}
