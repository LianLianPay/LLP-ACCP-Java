package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WithDrawalOrderInfo {
    private String txn_seqno;
    private String txn_time;
    private Double total_amount;
    private Double fee_amount;
    private String order_info;
    // 交易附言。提现交易附言。单笔金额大于等于5w必须提供
    private String postscript;
}
