package com.cardbyte.contactmanagment.integration.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class ZohoContactResponse{

    @JsonProperty("contact_id")
    private String zohoContactId;

}
