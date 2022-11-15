package com.lianlianpay.accpapi.v2.acctmgr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 匿名用户解绑银行卡 响应参数
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
