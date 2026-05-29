package com.apartmentmanagement.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ApartmentManagementException.class)
    public ResponseEntity<ApiResponse> handleException(ApartmentManagementException e){
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.ok().body(ApiResponse.errorException(errorCode.getCode(), errorCode.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleException(MethodArgumentNotValidException e) {
        return ResponseEntity.ok().body(ApiResponse.errorException(e.getStatusCode().value(), e.getBindingResult().getFieldError().getDefaultMessage()));
    }
}
