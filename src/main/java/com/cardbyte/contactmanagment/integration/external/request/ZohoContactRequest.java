package com.cardbyte.contactmanagment.integration.external.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZohoContactRequest{

    @JsonProperty("module")
    private String module;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("contactOwner")
    private String contactOwner;

    @JsonProperty("LeadSource")
    private String leadSource;

    @JsonProperty("accountName")
    private String accountName;

    @JsonProperty("vendorName")
    private String vendorName;

    @JsonProperty("title")
    private String title;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

}
