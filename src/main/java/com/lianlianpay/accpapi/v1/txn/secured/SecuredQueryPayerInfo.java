package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredQueryPayerInfo {
    /*
    付款方类型。
    用户：USER
    平台商户：MERCHANT
     */
    private String payer_type;
    // 付款方标识。付款方为用户时设置user_id。
    private String payer_id;
    // 委托代扣协议id
    private String method;
    private Double amount;
    // 已收退款金额
    private String receive_amount;
}
