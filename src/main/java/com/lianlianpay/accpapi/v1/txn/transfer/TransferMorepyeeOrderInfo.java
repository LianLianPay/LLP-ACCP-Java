package com.lianlianpay.accpapi.v1.txn.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TransferMorepyeeOrderInfo {
    private String txn_seqno;
    private String txn_time;
    private Double total_amount;
    /*
    代发交易用途。
    服务费
    信息费
    修理费
    佣金支付
    贷款
    其他
     */
    private String txn_purpose;
    // 订单信息，在查询API和支付通知中原样返回，可作为自定义参数使用
    private String order_info;
}
