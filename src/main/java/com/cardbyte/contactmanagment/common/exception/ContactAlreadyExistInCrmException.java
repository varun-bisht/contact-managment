package com.cardbyte.contactmanagment.common.exception;

import com.cardbyte.contactmanagment.common.constant.ContactManagementErrorCode;
import org.springframework.http.HttpStatus;

public class ContactAlreadyExistInCrmException extends BaseRuntimeException {

    public ContactAlreadyExistInCrmException() {
        super(ContactManagementErrorCode.CM04.name(), HttpStatus.BAD_REQUEST, ContactManagementErrorCode.CM04.getErrorDesc());
    }

}
