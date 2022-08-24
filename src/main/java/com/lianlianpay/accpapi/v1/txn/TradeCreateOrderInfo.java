package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TradeCreateOrderInfo {
    private String txn_seqno;
    private String txn_time;
    private Double total_amount;
    private Double fee_amount;
    private String order_info;
    private String goods_name;
    private String goods_url;
}
