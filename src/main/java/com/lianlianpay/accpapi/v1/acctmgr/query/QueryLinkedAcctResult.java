package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 绑卡信息查询 请求参数
 */
@Data
@EqualsAndHashCode
public class QueryLinkedAcctResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    // 绑定银行帐号列表
    List<LinkedAccount> linked_acctlist;
}
