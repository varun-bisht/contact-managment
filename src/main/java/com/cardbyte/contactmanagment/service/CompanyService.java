package com.cardbyte.contactmanagment.service;

import com.cardbyte.contactmanagment.entity.Company;
import com.cardbyte.contactmanagment.entity.Contact;
import com.cardbyte.contactmanagment.repository.CompanyRepository;
import com.cardbyte.contactmanagment.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService{

    private CompanyRepository companyRepository;

    public Company save(Company company){
        return companyRepository.save(company);
    }

}
