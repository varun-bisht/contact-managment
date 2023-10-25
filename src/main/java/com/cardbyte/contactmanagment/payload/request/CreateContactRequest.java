package com.cardbyte.contactmanagment.payload.request;

import com.cardbyte.contactmanagment.common.constant.ActionType;
import com.cardbyte.contactmanagment.common.constant.ContactType;
import com.cardbyte.contactmanagment.common.constant.SyncStatus;
import com.cardbyte.contactmanagment.entity.Company;
import lombok.Data;

@Data
public class CreateContactRequest{
    
    private String zohoContactId;
    
    private String firstName;
    
    private String lastName;

    private String email;

    private String phoneNo;

    private String address;
    
    private Long companyId;

    private String jobTitle;

    private ContactType contactType;

    private Boolean isActive;
    
    private String notes;

    private SyncStatus syncStatus;

    private ActionType actionType;
}
