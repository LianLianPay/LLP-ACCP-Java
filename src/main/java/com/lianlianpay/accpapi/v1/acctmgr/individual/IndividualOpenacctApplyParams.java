package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 个人用户开户申请 请求参数
 */
@Data
@EqualsAndHashCode
public class IndividualOpenacctApplyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String notify_url;
    private String open_sms_flag;
    private String risk_item;

    private IndividualOpenacctApplyBasicInfo basicInfo;
    private IndividualOpenacctApplyLinkedAcctInfo linkedAcctInfo;
    private IndividualOpenacctApplyAccountInfo accountInfo;
}
