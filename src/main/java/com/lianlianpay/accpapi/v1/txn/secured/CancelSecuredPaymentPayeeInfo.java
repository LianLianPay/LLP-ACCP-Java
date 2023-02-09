package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CancelSecuredPaymentPayeeInfo {
    private String payee_type;
    private String payee_id;
    private Double amount;
    private Double accept_amount;
    private Double refund_amount;
}
