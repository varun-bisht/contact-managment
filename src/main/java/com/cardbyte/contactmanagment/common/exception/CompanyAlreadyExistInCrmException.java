package com.cardbyte.contactmanagment.common.exception;

import com.cardbyte.contactmanagment.common.constant.ContactManagementErrorCode;
import org.springframework.http.HttpStatus;

public class CompanyAlreadyExistInCrmException extends BaseRuntimeException {

    public CompanyAlreadyExistInCrmException() {
        super(ContactManagementErrorCode.CM02.name(), HttpStatus.BAD_REQUEST, ContactManagementErrorCode.CM02.getErrorDesc());
    }

}
