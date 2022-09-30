package com.lianlianpay.accpapi.v1.acctmgr.webapge;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyLinkedAcctInfo {
    private String linked_accttype;
    private String linked_acctno;
    private String linked_bankcode;
    private String linked_brbankno;
    private String linked_brbankname;
    private String linked_acctname;
    private String linked_phone;
}
