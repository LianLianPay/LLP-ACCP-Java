package com.lianlianpay.accpapi.v1.acctmgr.find;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 找回密码验证 响应参数
 */
@Data
@EqualsAndHashCode
public class FindPasswordVerifyResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
}
