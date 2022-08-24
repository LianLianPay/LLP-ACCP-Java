package com.lianlianpay.accpapi.v1.cashier;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CashierPayCreateOrderInfo {
    private String txn_seqno;
    private String txn_time;
    private Double total_amount;
    private String order_info;
    private String goods_name;
    private String goods_url;
}
