package com.lianlianpay.accpapi.v1.txn.papay;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 委托代扣 响应参数
 */
@Data
@EqualsAndHashCode
public class PaymentPapayResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private Double total_amount;
    private String accp_txno;
    /*
    支付交易状态。
    TRADE_WAIT_PAY:交易处理中
    TRADE_SUCCESS:交易成功
    TRADE_CLOSE:交易失败
    支付交易状态以此为准，商户必须依据此字段值进行后续业务逻辑处理。
     */
    private String txn_status;
    private String accounting_date;
    private String finish_time;
    // 渠道失败原因。渠道返回失败时,返回具体失败原因。
    private String fail_reason;
}
