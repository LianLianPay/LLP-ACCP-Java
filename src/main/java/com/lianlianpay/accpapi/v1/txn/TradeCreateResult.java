package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 支付统一创单 响应参数
 */
@Data
@EqualsAndHashCode
@ToString
public class TradeCreateResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private Double total_amount;
    private String txn_seqno;
    private String accp_txno;
}
