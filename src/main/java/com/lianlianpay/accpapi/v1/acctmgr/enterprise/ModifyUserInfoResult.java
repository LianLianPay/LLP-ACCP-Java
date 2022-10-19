package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业用户信息修改 响应参数
 */
@Data
@EqualsAndHashCode
public class ModifyUserInfoResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String accp_txno;
    private String remark;
}
