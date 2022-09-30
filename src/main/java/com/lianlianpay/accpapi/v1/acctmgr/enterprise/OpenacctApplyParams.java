package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业用户开户申请 请求参数
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

    // 开户基本信息
    private OpenacctApplyBasicInfo basicInfo;
    // 开户绑卡信息
    private OpenacctApplyLinkedAcctInfo linkedAcctInfo;
    // 企业法定代表人信息
    private OpenacctApplyLegalreptInfo legalreptInfo;
    // 企业联系人信息
    private OpenacctApplyContactsInfo contactsInfo;
    // 企业经营信息
    private OpenacctApplyBusinessInfo businessInfo;
    // 企业基本户信息
    private OpenacctApplyBasicAcctInfo basicAcctInfo;
    // 受益所有人信息uboInfos(可选，若传uboInfos，则按下列参数要求传)
    private OpenacctApplyUboInfos uboInfos;
    // 开户账户申请信息
    private OpenacctApplyAccountInfo applyAccountInfo;
}
