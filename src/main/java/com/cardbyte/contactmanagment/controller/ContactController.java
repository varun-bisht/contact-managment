package com.cardbyte.contactmanagment.controller;


import com.cardbyte.contactmanagment.common.model.ApiSucessResponse;
import com.cardbyte.contactmanagment.entity.Contact;
import com.cardbyte.contactmanagment.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/contact/")
public class ContactController{

    private ContactService contactService;

    @PostMapping("create")
    private ResponseEntity<Contact> save(@RequestBody Contact contact){
        return ApiSucessResponse.buildSucess(contactService.save(contact));
    }

}
