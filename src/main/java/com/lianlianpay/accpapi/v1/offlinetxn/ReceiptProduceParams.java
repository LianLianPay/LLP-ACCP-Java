package com.lianlianpay.accpapi.v1.offlinetxn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 电子回单生成 请求参数
 */
@Data
@EqualsAndHashCode
public class ReceiptProduceParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private String txn_time;
    // 原交易流水号。二选一
    private String trade_txn_seqno;
    // 原交易ACCP系统单号。二选一
    private String trade_accp_txno;
    /*
    原交易订单类型。
    PAYBILL:支付（包含充值，消费，内部代发，担保消费，担保确认）
    CASHOUT:外部代发，提现
    REFUND:退款
     */
    private String trade_bill_type;
    // 订单总金额，单位为元，精确到小数点后两位。
    private Double total_amount;
}
