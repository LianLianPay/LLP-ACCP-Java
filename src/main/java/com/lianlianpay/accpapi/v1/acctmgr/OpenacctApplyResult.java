package com.lianlianpay.accpapi.v1.acctmgr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户开户申请(页面接入) 响应参数
 */
@Data
@EqualsAndHashCode
public class OpenacctApplyResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String accp_txno;
    private String gateway_url;
}
