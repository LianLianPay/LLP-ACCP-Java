package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 绑卡信息查询 请求参数
 */
@Data
@EqualsAndHashCode
public class QueryLinkedAcctParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
}
