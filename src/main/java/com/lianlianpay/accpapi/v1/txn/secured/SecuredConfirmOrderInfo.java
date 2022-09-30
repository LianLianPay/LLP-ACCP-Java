package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredConfirmOrderInfo {
    private String confirm_seqno;
    private String confirm_time;
    private Double confirm_amount;
    private Double coupon_amount;
}
