package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PaymentBankCardInfo {
    private String linked_agrtno;
    private String linked_acctno;
    private String linked_phone;
    private String linked_acctname;
    private String id_type;
    private String id_no;
}
