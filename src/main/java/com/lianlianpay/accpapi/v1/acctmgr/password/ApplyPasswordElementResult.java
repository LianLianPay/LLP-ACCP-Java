package com.lianlianpay.accpapi.v1.acctmgr.password;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 申请密码控件Token 响应参数
 */
@Data
@EqualsAndHashCode
public class ApplyPasswordElementResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    // 用于唤起密码控件的token
    private String password_element_token;
}
