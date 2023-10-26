package com.cardbyte.contactmanagment.common.exception;

import com.cardbyte.contactmanagment.common.constant.ContactManagementErrorCode;
import org.springframework.http.HttpStatus;

public class CompanyNotFoundException extends BaseRuntimeException {

    public CompanyNotFoundException() {
        super(ContactManagementErrorCode.CM03.name(), HttpStatus.BAD_REQUEST, ContactManagementErrorCode.CM03.getErrorDesc());
    }

}
