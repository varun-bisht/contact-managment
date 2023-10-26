package com.cardbyte.contactmanagment.service;

import com.cardbyte.contactmanagment.common.exception.CompanyAlreadyExistInCrmException;
import com.cardbyte.contactmanagment.entity.Company;
import com.cardbyte.contactmanagment.entity.Contact;
import com.cardbyte.contactmanagment.integration.external.ZohoCrmIntegrationService;
import com.cardbyte.contactmanagment.integration.external.request.ZohoCompanyRequest;
import com.cardbyte.contactmanagment.integration.external.response.ZohoCompanyResponse;
import com.cardbyte.contactmanagment.repository.CompanyRepository;
import com.cardbyte.contactmanagment.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CompanyService{

    private CompanyRepository companyRepository;
    private ZohoCrmIntegrationService zohoCrmIntegrationService;

    public Company save(Company company){

        ZohoCompanyResponse zohoCompanyResponseMono = zohoCrmIntegrationService.postDataToZohoCrm(ZohoCompanyRequest.builder()
                                                                                                                    .name(company.getName())
                                                                                                                    .type(company.getType())
                                                                                                                    .industry(company.getIndustry())
                                                                                                                    .website(company.getWebsite())
                                                                                                                    .phoneNo(company.getPhoneNo())
                                                                                                                    .address(company.getAddress())
                                                                                                                    .description(company.getDescription())
                                                                                                                    .contactPerson(company.getContactPerson())
                                                                                                                    .build())
                                                                               .block();
        company.setZohoAccountID(zohoCompanyResponseMono.getZohoCompanyId());
        return companyRepository.save(company);
    }

}
