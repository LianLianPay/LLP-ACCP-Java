package com.lianlianpay.accpapi.v1.offlinetxn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ReceiptInfo {
    private String receipt_filename;
    private Double amount;
    /*
    付款方类型。
    用户：USER
    平台商户：MERCHANT
     */
    private String payer_type;
    private String payer_id;
    private String method;
    private String payee_type;
    private String payee_id;
}
