package com.lianlianpay.accpapi.v1.txn.refund;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OriginalOrderInfo {
    private String txn_seqno;
    // 订单总金额，单位为元，精确到小数点后两位
    private Double total_amount;
}
