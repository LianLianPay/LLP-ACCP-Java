package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户等级修改 请求参数
 */
@Data
@EqualsAndHashCode
public class ModifyUserLevelParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;

    //开户账户申请信息accountInfo
    private OpenacctApplyAccountInfo accountInfo;
}
