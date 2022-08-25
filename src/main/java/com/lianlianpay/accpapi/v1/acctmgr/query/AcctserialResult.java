package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 资金流水详情列表查询 响应参数
 */
@Data
@EqualsAndHashCode
public class AcctserialResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String page_no;
    private String total_out_amt;
    private String total_in_amt;
    private String total_num;
    private String total_page;
    private List<AcctserialAcctbal> acctbal_list;
}
