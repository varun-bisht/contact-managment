package com.cardbyte.contactmanagment.common.util;

import com.cardbyte.contactmanagment.common.constant.ContactManagementErrorCode;
import com.cardbyte.contactmanagment.common.exception.BaseRuntimeException;
import com.cardbyte.contactmanagment.common.model.ApiErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler()
    public ResponseEntity<Object> generalExceptions(Exception ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse  = ApiErrorResponse.builder().error(ContactManagementErrorCode.CM00.name()).message(
                ContactManagementErrorCode.CM00.getErrorDesc()).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return new ResponseEntity<>(apiErrorResponse, new HttpHeaders(), apiErrorResponse.getStatus());
    }

    @ExceptionHandler({BaseRuntimeException.class})
    public ResponseEntity<Object> businessExceptions(BaseRuntimeException ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse  = ApiErrorResponse.builder().error(ex.getErrorCode()).message(
                ContactManagementErrorCode.valueOf(ex.getErrorCode()).getErrorDesc()).status(ex.getHttpStatus()).build();
        return new ResponseEntity<>(apiErrorResponse, new HttpHeaders(), apiErrorResponse.getStatus());
    }

}
