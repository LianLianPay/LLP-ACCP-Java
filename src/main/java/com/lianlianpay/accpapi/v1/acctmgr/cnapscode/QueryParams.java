package com.lianlianpay.accpapi.v1.acctmgr.cnapscode;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 大额行号查询 请求参数
 */
@Data
@EqualsAndHashCode
public class QueryParams {
    private String timestamp;
    private String oid_partner;
    // 银行编码
    private String bank_code;
    // 开户支行名称， 支持模糊查询
    private String brabank_name;
    // 开户行所在省市编码
    private String city_code;
}
