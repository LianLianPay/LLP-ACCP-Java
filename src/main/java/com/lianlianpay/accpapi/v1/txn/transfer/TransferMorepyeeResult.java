package com.lianlianpay.accpapi.v1.txn.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 内部代发申请 响应参数
 */
@Data
@EqualsAndHashCode
public class TransferMorepyeeResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    // 订单总金额，单位为元，精确到小数点后两位
    private Double total_amount;
    private String accp_txno;
    // 支付授权令牌，有效期30分钟。当交易需要二次验证的时候，需要通过token调用调用交易二次短信验证接口
    private String token;
    // 账务日期。ACCP系统交易账务日期，交易成功时返回，格式：yyyyMMdd
    private String accounting_date;
}
