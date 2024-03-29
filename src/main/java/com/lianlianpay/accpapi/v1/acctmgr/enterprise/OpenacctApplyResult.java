package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业用户开户申请 响应参数
 */
@Data
@EqualsAndHashCode
public class OpenacctApplyResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String user_name;
    private String txn_seqno;
    private String accp_txno;
    private String oid_userno;
    private String token;
    /*
    用户状态。
    ACTIVATE_PENDING :已登记或开户失败（原待激活）
    CHECK_PENDING :审核中（原待审核）
    REMITTANCE_VALID_PENDING :审核通过，待打款验证（企业用户使用，暂未要求）
    NORMAL :正常
    CANCEL :销户
    PAUSE :暂停
    ACTIVATE_PENDING_NEW ：待激活
     */
    private String user_status;
}
