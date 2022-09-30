package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 个人用户信息修改 请求参数
 */
@Data
@EqualsAndHashCode
public class IndividualModifyUserInfoParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String notify_url;
    // 基本信息更新
    private IndividualModifyUserInfoBasicInfo basicInfo;
}
