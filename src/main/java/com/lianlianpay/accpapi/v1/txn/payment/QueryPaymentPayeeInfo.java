package com.lianlianpay.accpapi.v1.txn.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class QueryPaymentPayeeInfo {
    /*
    收款方类型。
    用户：USER
    平台商户：MERCHANT
     */
    private String payee_type;
    // 收款方标识
    private String payee_id;
    // 付款金额
    private String amount;
}
