package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 个人用户开户申请 请求参数
 */
@Data
@EqualsAndHashCode
public class OpenacctApplyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String notify_url;
    private String open_sms_flag;
    private String risk_item;

    private OpenacctApplyBasicInfo basicInfo;
    private OpenacctApplyLinkedAcctInfo linkedAcctInfo;
    private OpenacctApplyAccountInfo accountInfo;
}
