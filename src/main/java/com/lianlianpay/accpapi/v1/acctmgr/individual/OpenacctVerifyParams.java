package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 个人用户开户验证 请求参数
 */
@Data
@EqualsAndHashCode
public class OpenacctVerifyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String token;
    private String verify_code;
    private String password;
    private String random_key;
}
