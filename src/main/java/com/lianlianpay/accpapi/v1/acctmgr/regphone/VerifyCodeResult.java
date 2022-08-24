package com.lianlianpay.accpapi.v1.acctmgr.regphone;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 绑定手机验证码申请/验证 响应参数
 */
@Data
@EqualsAndHashCode
public class VerifyCodeResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String reg_phone;
}
