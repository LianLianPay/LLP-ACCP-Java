package com.lianlianpay.accpapi.v1.acctmgr.webapge;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户开户申请(页面接入) 请求参数
 */
@Data
@EqualsAndHashCode
public class OpenacctApplyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String flag_chnl;
    private String return_url;
    private String notify_url;
    private String user_type;
    private String cust_trade_serial_type;

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
    // 页面模板定制
    private OpenacctApplyTheme theme;
    // 开户账户申请信息
    private OpenacctApplyAccountInfo accountInfo;
}
