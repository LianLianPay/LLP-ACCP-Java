package com.lianlianpay.accpapi.v1.txn.refund;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class RefundMethod {
    private String method;
    private Double amount;
}
