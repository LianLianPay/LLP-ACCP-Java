package com.lianlianpay.accpapi.v1.offlinetxn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 电子回单生成 响应参数
 */
@Data
@EqualsAndHashCode
public class ReceiptProduceResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String txn_seqno;
    private String trade_txn_seqno;
    private String trade_accp_txno;
    private String total_amount;
    // 电子回单流水号。ACCP系统唯一定位一笔单子的电子回单。
    private String receipt_accp_txno;
    // 授权令牌。有效期为120分钟。在电子回单下载接口需要传入。
    private String token;
}
