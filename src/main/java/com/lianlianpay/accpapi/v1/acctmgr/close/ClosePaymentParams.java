package com.lianlianpay.accpapi.v1.acctmgr.close;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付单关单 请求参数
 */
@Data
@EqualsAndHashCode
public class ClosePaymentParams {
    private String timestamp;
    private String oid_partner;
    // 商户系统唯一交易流水号。二选一
    private String txn_seqno;
    // ACCP系统交易单号。二选一
    private String accp_txno;
}
