package com.lianlianpay.accpapi.v1.acctmgr.find;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 找回密码验证 请求参数
 */
@Data
@EqualsAndHashCode
public class FindPasswordVerifyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String token;
    private String verify_code;
    private String random_key;
    private String password;
}
