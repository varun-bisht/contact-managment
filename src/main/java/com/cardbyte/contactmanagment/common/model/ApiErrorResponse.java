package com.cardbyte.contactmanagment.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
public class ApiErrorResponse {

    private String message;
    private String error;
    protected HttpStatus status;
}
