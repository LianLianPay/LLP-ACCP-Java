package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredQueryAcceptInfo {
    private String accp_txno;
    private String txn_seqno;
    /*
    担保确认单状态
    PAYBILL_FINISH：支付完成，交易成功结束
    WAIT_PAY：交易创建，等待付款
    PRE_FINISH：预付完成
    REFUND_MONEY：撤销
    PAY_CLOSE： 支付关闭
     */
    private String state;
}
