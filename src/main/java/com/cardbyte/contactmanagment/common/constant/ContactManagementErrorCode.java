package com.cardbyte.contactmanagment.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ContactManagementErrorCode{

    CM00("something went wrong"),
    CM01("contact not found");

    private final String errorDesc;
}
