package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 余额支付 请求参数
 */
@Data
@EqualsAndHashCode
public class PaymentBalanceParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private Double total_amount;
    private Double coupon_amount;
    private String directionalpay_flag;
    private String risk_item;

    private PaymentPayerInfo payerInfo;
}
