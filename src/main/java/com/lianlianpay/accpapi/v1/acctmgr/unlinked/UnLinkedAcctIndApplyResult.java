package com.lianlianpay.accpapi.v1.acctmgr.unlinked;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 个人用户解绑银行卡 响应参数
 */
@Data
@EqualsAndHashCode
public class UnLinkedAcctIndApplyResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String accp_txno;
}
