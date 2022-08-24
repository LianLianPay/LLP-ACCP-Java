package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 银行卡快捷支付 响应参数
 */
@Data
@EqualsAndHashCode
public class PaymentBankCardResult extends PaymentResult {
    private String linked_agrtno;
    private String accounting_date;
    private String finish_time;
}
