package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户等级修改 响应参数
 */
@Data
@EqualsAndHashCode
public class ModifyUserLevelResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String accp_txno;
    private String open_account_will_url;
}
