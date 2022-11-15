package com.lianlianpay.accpapi.v1.txn.refund;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PyeeRefundInfo {
    // 原收款方id，本次退款需要处理的原交易收款方id
    private String payee_id;
    /*
    原收款方类型。
    用户：USER
    平台商户：MERCHANT
     */
    private String payee_type;
    /*
    原收款方账户类型。
    用户账户：USEROWN
    平台商户自有资金账户：MCHOWN
    平台商户担保账户：MCHASSURE
    平台商户优惠券账户：MCHCOUPON
    平台商户手续费账户：MCHFEE
     */
    private String payee_accttype;
    // 退款金额。本次需要退款的金额，不允许超过对应原收款方的收款金额
    private Double payee_refund_amount;
    // 垫资标识。当原收款方金额不足时，是否由平台垫资的标识，默认:N
    private String is_advance_pay;
}
