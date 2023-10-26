package com.cardbyte.contactmanagment.integration.external.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZohoCompanyRequest{

    private String name;
    private String type;
    private String industry;
    private String website;
    private String phoneNo;
    private String address;
    private String description;
    private String contactPerson;
}
