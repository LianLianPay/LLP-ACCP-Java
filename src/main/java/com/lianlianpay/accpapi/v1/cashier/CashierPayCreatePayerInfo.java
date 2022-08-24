package com.lianlianpay.accpapi.v1.cashier;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CashierPayCreatePayerInfo {
    private String payer_type;
    private String payer_id;
}
