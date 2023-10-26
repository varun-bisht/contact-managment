package com.cardbyte.contactmanagment.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ContactManagementErrorCode{

    CM00("something went wrong"),
    CM01("contact not found"),
    CM02("company already exist in crm , please sync cardbyte data with your crm"),
    CM03("company not found"),
    CM04("contact already exist in crm , please sync cardbyte data with your crm");

    private final String errorDesc;
}
