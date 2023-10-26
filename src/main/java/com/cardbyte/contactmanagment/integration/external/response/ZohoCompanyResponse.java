package com.cardbyte.contactmanagment.integration.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class ZohoCompanyResponse{

    @JsonProperty("company_id")
    private String zohoCompanyId;

    @JsonProperty("user_id")
    private String userId;

}
