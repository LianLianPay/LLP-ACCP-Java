package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class LinkedAccount {
    // 个人用户绑定的银行卡号，企业用户绑定的银行帐号。
    private String linked_acctno;
    // 银行编码
    private String linked_bankcode;
    // 企业用户开户行行号
    private String linked_brbankno;
    // 对公账户开户行名。企业用户绑定账户开户支行名称。
    private String linked_brbankname;
    // 银行预留手机号
    private String linked_phone;
    // 绑卡协议号
    private String linked_agrtno;
}
