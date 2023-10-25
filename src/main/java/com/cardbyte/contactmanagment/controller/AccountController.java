package com.cardbyte.contactmanagment.controller;

import com.cardbyte.contactmanagment.common.model.ApiSucessResponse;
import com.cardbyte.contactmanagment.entity.Account;
import com.cardbyte.contactmanagment.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/account/")
public class AccountController{

     private AccountService accountService;

     @PostMapping("create")
     private ResponseEntity<Account> save(@RequestBody Account account){
         return ApiSucessResponse.buildSucess(accountService.save(account));
     }


}
