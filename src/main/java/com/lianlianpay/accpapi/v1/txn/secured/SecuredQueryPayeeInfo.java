package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredQueryPayeeInfo {
    /*
    收款方类型。
    用户：USER
    平台商户：MERCHANT
     */
    private String payee_type;
    private String payee_id;
    // 收款金额
    private Double amount;
    // 已确认金额
    private Double accept_amount;
    // 退款金额
    private Double refund_amount;
}
