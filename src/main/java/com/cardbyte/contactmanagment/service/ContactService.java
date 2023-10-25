package com.cardbyte.contactmanagment.service;

import com.cardbyte.contactmanagment.entity.Company;
import com.cardbyte.contactmanagment.entity.Contact;
import com.cardbyte.contactmanagment.payload.request.CreateContactRequest;
import com.cardbyte.contactmanagment.repository.CompanyRepository;
import com.cardbyte.contactmanagment.repository.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService{

    private ContactRepository contactRepository;

    private CompanyRepository companyRepository;

    public Contact save(CreateContactRequest createContactRequest){

        Company presistCompany = companyRepository.findById(createContactRequest.getCompanyId())
                                                  .orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + createContactRequest.getCompanyId()));

        return contactRepository.save(Contact.builder()
                                             .zohoContactId(createContactRequest.getZohoContactId())
                                             .firstName(createContactRequest.getFirstName())
                                             .lastName(createContactRequest.getLastName())
                                             .email(createContactRequest.getEmail())
                                             .phoneNo(createContactRequest.getPhoneNo())
                                             .address(createContactRequest.getAddress())
                                             .company(presistCompany)
                                             .jobTitle(createContactRequest.getJobTitle())
                                             .contactType(createContactRequest.getContactType())
                                             .isActive(true)
                                             .notes(createContactRequest.getNotes())
                                             .syncStatus(createContactRequest.getSyncStatus())
                                             .actionType(createContactRequest.getActionType())
                                             .build());
    }

}
