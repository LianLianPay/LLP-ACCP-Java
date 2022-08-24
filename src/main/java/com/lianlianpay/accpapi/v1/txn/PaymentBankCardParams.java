package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 银行卡快捷支付 请求参数
 */
@Data
@EqualsAndHashCode
public class PaymentBankCardParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private Double total_amount;
    private String risk_item;
    private String directionalpay_flag;

    // 付款方信息
    private PaymentPayerInfo payerInfo;
    // 付款银行卡信息
    private PaymentBankCardInfo bankCardInfo;
    // 付款方式信息
    private PaymentBankCardPayMethods[] payMethods;

}
