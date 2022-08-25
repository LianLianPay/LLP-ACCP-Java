package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 资金流水详情查询 请求参数
 */
@Data
@EqualsAndHashCode
public class AcctserialDetailParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String user_type;
    private String jno_acct;
}
