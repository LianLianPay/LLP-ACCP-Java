package com.lianlianpay.accpapi.v1.txn.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class QueryPaymentOrderInfo {
    private String txn_seqno;
    // 商户系统交易时间
    private String txn_time;
    // 订单总金额，单位为元
    private Double total_amount;
    private String order_info;
}
