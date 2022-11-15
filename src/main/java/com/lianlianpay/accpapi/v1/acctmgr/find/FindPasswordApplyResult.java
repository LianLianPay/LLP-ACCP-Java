package com.lianlianpay.accpapi.v1.acctmgr.find;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 找回密码申请 响应参数
 */
@Data
@EqualsAndHashCode
public class FindPasswordApplyResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String token;
    private String reg_phone;
}
