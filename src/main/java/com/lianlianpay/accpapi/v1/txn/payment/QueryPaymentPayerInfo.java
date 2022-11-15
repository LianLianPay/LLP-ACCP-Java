package com.lianlianpay.accpapi.v1.txn.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class QueryPaymentPayerInfo {
    /*
    付款方类型。
    用户：USER
    平台商户：MERCHANT
     */
    private String payer_type;
    /*
    付款方标识。
    付款方为用户时设置user_id
    付款方为商户时设置平台商户号
     */
    private String payer_id;
    // 付款方式
    private String method;
    // 付款金额。付款方式对应的金额
    private Double amount;
}
