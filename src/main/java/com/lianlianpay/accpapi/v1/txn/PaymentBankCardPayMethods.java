package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PaymentBankCardPayMethods {
    private String method;
    private Double amount;
}
