package com.apartmentmanagement.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ApartmentManagementException extends RuntimeException {
    private final ErrorCode errorCode;
}
