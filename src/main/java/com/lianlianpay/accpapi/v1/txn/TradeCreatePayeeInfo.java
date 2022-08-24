package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TradeCreatePayeeInfo {
    private String payee_id;
    private String payee_type;
    private String payee_accttype;
    private String payee_amount;
    private String payee_memo;
}
