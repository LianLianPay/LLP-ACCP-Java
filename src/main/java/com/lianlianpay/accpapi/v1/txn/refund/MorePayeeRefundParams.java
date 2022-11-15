package com.lianlianpay.accpapi.v1.txn.refund;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 退款申请 请求参数
 */
@Data
@EqualsAndHashCode
public class MorePayeeRefundParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String notify_url;
    // 退款原因
    private String refund_reason;
    // 原商户订单信息
    private OriginalOrderInfo originalOrderInfo;
    // 退款订单信息
    private RefundOrderInfo refundOrderInfo;
    // 原收款方退款信息
    private List<PyeeRefundInfo> pyeeRefundInfos;
    // 原付款方式
    private List<RefundMethod> refundMethods;
}
