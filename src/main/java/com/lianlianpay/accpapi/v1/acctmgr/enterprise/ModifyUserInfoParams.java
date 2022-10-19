package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 企业用户信息修改 请求参数
 */
@Data
@EqualsAndHashCode
public class ModifyUserInfoParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String notify_url;
    // 基本信息更新
    private OpenacctApplyBasicInfo basicInfo;
    // 企业法定代表人信息更新
    private OpenacctApplyLegalreptInfo legalreptInfo;
    // 企业联系人信息更新
    private OpenacctApplyContactsInfo contactsInfo;
    // 企业经营信息更新
    private OpenacctApplyBusinessInfo businessInfo;
    // 已有受益所有人信息替换
    private List<OpenacctApplyUboInfos> uboInfos;
}
