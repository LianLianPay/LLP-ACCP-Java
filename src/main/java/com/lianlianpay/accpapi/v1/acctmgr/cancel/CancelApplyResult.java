package com.lianlianpay.accpapi.v1.acctmgr.cancel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 销户申请 响应参数
 */
@Data
@EqualsAndHashCode
public class CancelApplyResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String accp_txno;
}
