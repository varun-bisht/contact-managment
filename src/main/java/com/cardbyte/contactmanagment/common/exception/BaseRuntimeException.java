package com.cardbyte.contactmanagment.common.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseRuntimeException extends RuntimeException {

    private String errorCode;
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public BaseRuntimeException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BaseRuntimeException(String errorCode, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public BaseRuntimeException(String errorCode, HttpStatus httpStatus, String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
