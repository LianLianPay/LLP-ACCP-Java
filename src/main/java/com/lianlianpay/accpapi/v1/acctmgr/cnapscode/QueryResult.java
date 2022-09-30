package com.lianlianpay.accpapi.v1.acctmgr.cnapscode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 大额行号查询 请求参数
 */
@Data
@EqualsAndHashCode
public class QueryResult {
    private String ret_code;
    private String ret_msg;
    private String bank_code;
    List<BankCnaps> card_list;
}
