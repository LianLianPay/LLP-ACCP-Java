package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PaymentPayerInfo {
    private String user_id;
    private String password;
    private String random_key;
}
