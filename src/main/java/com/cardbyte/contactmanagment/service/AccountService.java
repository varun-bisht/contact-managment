package com.cardbyte.contactmanagment.service;

import com.cardbyte.contactmanagment.entity.Account;
import com.cardbyte.contactmanagment.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService{

    private AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }

}
