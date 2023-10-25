package com.cardbyte.contactmanagment.controller;


import com.cardbyte.contactmanagment.common.model.ApiSucessResponse;
import com.cardbyte.contactmanagment.entity.Company;
import com.cardbyte.contactmanagment.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/company/")
public class CompanyController{

    private CompanyService companyService;

    @PostMapping("create")
    private ResponseEntity<Company> save(@RequestBody Company company){
        return ApiSucessResponse.buildSucess(companyService.save(company));
    }

}
