package com.cardbyte.contactmanagment.service;

import com.cardbyte.contactmanagment.entity.Account;
import com.cardbyte.contactmanagment.entity.Contact;
import com.cardbyte.contactmanagment.repository.AccountRepository;
import com.cardbyte.contactmanagment.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService{

    private ContactRepository contactRepository;

    public Contact save(Contact contact){
        return contactRepository.save(contact);
    }

}
