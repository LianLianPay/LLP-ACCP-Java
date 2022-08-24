package com.lianlianpay.accpapi.v1.acctmgr.regphone;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 绑定手机验证码验证 请求参数
 */
@Data
@EqualsAndHashCode
public class VerifyCodeVerifyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String reg_phone;
    private String verify_code;
}
