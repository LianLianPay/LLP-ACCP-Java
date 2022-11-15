package com.lianlianpay.accpapi.v1.txn.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付结果查询 请求参数
 */
@Data
@EqualsAndHashCode
public class QueryPaymentParams {
    private String timestamp;
    private String oid_partner;
    // 商户系统唯一交易流水号。【三选一】，建议优先使用ACCP系统交易单号
    private String txn_seqno;
    // ACCP系统交易单号。【三选一】，建议优先使用ACCP系统交易单号
    private String accp_txno;
    // 上游渠道流水号。【三选一】，建议优先使用 ACCP 系统交易单号
    private String sub_chnl_no;
}
