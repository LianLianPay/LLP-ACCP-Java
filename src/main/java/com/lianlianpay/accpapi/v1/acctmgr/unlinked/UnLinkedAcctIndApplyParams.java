package com.lianlianpay.accpapi.v1.acctmgr.unlinked;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 个人用户解绑银行卡 请求参数
 */
@Data
@EqualsAndHashCode
public class UnLinkedAcctIndApplyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String notify_url;
    // 绑定银行账号。个人用户绑定的银行卡号
    private String linked_acctno;
    // 支付密码
    private String password;
    private String random_key;
}
