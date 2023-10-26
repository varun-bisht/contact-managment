package com.cardbyte.contactmanagment.service;

import com.cardbyte.contactmanagment.common.exception.CompanyNotFoundException;
import com.cardbyte.contactmanagment.entity.Company;
import com.cardbyte.contactmanagment.entity.Contact;
import com.cardbyte.contactmanagment.integration.external.ZohoCrmIntegrationService;
import com.cardbyte.contactmanagment.integration.external.request.ZohoContactRequest;
import com.cardbyte.contactmanagment.integration.external.response.ZohoContactResponse;
import com.cardbyte.contactmanagment.payload.request.CreateContactRequest;
import com.cardbyte.contactmanagment.repository.CompanyRepository;
import com.cardbyte.contactmanagment.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService{

    private ContactRepository contactRepository;

    private CompanyRepository companyRepository;

    private ZohoCrmIntegrationService zohoCrmIntegrationService;


    public Contact save(CreateContactRequest createContactRequest){

        Company presistCompany = companyRepository.findById(createContactRequest.getCompanyId())
                                                  .orElseThrow(() -> new CompanyNotFoundException());

        ZohoContactResponse zohoContactResponse = zohoCrmIntegrationService.postContactDataToZohoCrm(ZohoContactRequest.builder()
                                                                                                                       .module("Contacts")
                                                                                                                       .lastName(createContactRequest.getLastName())
                                                                                                                       .leadSource("")
                                                                                                                       .accountName("")
                                                                                                                       .title(createContactRequest.getJobTitle())
                                                                                                                       .phone(createContactRequest.getPhoneNo())
                                                                                                                       .email(createContactRequest.getEmail())
                                                                                                                       .firstName(createContactRequest.getFirstName())
                                                                                                                       .contactOwner("60024619092")
                                                                                                                       .vendorName("591288000000309017")
                                                                                                                       .build())
                                                                           .block();

        return contactRepository.save(Contact.builder()
                                             .zohoContactId(zohoContactResponse.getZohoContactId())
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
