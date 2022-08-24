package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IndividualOpenacctApplyLinkedAcctInfo {
    private String linked_acctno;
    private String linked_phone;
}
