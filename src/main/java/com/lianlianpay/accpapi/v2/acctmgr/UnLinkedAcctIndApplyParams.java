package com.lianlianpay.accpapi.v2.acctmgr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 匿名用户解绑银行卡 请求参数
 */
@Data
@EqualsAndHashCode
public class UnLinkedAcctIndApplyParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private String user_id;
    private String txn_time;
    private String notify_url;
    // 绑定银行账号。该字段需要RSA公钥加密传输
    private String linked_acctno;
}
