package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredQueryOrderInfo {
    private String txn_seqno;
    private String txn_time;
    private Double total_amount;
    /*
    担保订单状态
    WAIT_BUYER_PAY:等待付款
    WAIT_BUYER_CONFIRM:等待确认
    CONFIRMING:确认中
    CONFIRM_SUCCESS:确认完成
    TRADE_CLOSED:交易过期关闭
    REFUND_SUCCESS:退款完成
    担保交易状态以该字段为准。当担保消费支付未完成，是等待支付状态；等所有金额除已退款的部分都确认完成，担保订单状态是确认完成状态；部分已确认是确认中；未调用确认接口是等待确认；已全额退款的话是退款完成
     */
    private String secure_status;
    // 优惠券总金额
    private Double coupon_amt;
    // 优惠券已兑付金额
    private Double coupon_transfer_amt;
    // 优惠券已使用金额
    private Double coupon_pay_amt;
    // 优惠券已退款金额
    private Double coupon_refund_amt;
    /*
    优惠券支付模式：默认，CONSUME_SUCCESS_PAY。
    CONSUME_SUCCESS_PAY：支付成功后，转到担保账户。
    SECURED_CONFIRM_AUTO：担保确认后转到担保账户，优惠券金额由系统计算。
    SECURED_CONFIRM_SUBMIT：担保确认后转到担保账户，优惠券金额由商户上送。
     */
    private String coupon_pay_mode;
}
