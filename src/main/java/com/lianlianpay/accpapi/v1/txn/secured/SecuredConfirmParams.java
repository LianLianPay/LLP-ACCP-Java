package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 担保交易确认 请求参数
 */
@Data
@EqualsAndHashCode
public class SecuredConfirmParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    /*
    确认方式。
    ALL：全订单金额一次性确认（创单时指定了收款方）
    PART：订单金额部分多次确认
     */
    private String confirm_mode;
    // 原商户订单信息
    private SecuredConfirmOriginalOrderInfo originalOrderInfo;
    // 确认订单信息
    private SecuredConfirmOrderInfo confirmOrderInfo;
    // 确认收款方信息
    private SecuredConfirmPayeeInfo[] payeeInfo;
}
