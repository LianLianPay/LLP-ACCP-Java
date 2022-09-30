package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户委托协议申请 响应参数
 */
@Data
@EqualsAndHashCode
public class PapAgreeResult {
    private String ret_code;
    private String ret_msg;
    private String gateway_url;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String accp_txno;
}
