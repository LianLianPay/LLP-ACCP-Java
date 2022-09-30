package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredConfirmPayeeInfo {
    private String payee_id;
    private String payee_type;
    private String payee_oid_partner;
    private String payee_amount;
}
