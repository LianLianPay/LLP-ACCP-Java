package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息查询 响应参数
 */
@Data
@EqualsAndHashCode
public class UserInfoResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String user_name;
    private String oid_userno;
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
    private String bank_open_flag;
    private String remark;
    private String bank_account;
}
