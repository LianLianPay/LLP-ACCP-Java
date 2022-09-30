package com.lianlianpay.accpapi.v1.acctmgr.close;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付单关单 响应参数
 */
@Data
@EqualsAndHashCode
public class ClosePaymentResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String accp_txno;
    private String total_amount;
}
