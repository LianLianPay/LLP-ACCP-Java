package com.lianlianpay.accpapi.v1.txn.papay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PaymentPapayOrderInfo {
    private String txn_seqno;
    private String txn_time;
    private Double total_amount;
    private String order_info;
    private String goods_name;
    private String goods_url;
    /*
    优惠券支付模式：默认，CONSUME_SUCCESS_PAY。
    CONSUME_SUCCESS_PAY：支付成功后，转到担保账户。
    SECURED_CONFIRM_AUTO：担保确认后转到担保账户，优惠券金额由系统计算。
    SECURED_CONFIRM_SUBMIT：担保确认后转到担保账户，优惠券金额由商户上送。
     */
    private String coupon_pay_mode;
}
