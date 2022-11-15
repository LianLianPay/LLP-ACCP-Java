package com.lianlianpay.accpapi.v1.txn.refund;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class RefundOrderInfo {
    // 退款订单号。标识一次退款请求，商户系统需要保证唯一
    private String refund_seqno;
    // 订单信息。用于订单说明，在异步通知透传返回
    private String order_info;
    // 退款订单时间。退款交易商户系统交易时间，格式:yyyyMMddHHmmss
    private String refund_time;
    // 退款总金额
    private Double refund_amount;
}
