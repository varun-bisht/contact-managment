package com.cardbyte.contactmanagment.common.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiSucessResponse<T>{


    public static <T> ResponseEntity<T> buildSucess(T data){
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }
}
