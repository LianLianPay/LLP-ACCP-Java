package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 担保交易信息查询 响应参数
 */
@Data
@EqualsAndHashCode
public class SecuredQueryResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String accp_txno;
    // 商户订单信息
    private SecuredQueryOrderInfo orderInfo;
    // 付款方信息
    private List<SecuredQueryPayerInfo> payerInfo;
    // 收款方信息
    private List<SecuredQueryPayeeInfo> payeeInfo;
    // 担保支付订单
    private SecuredQueryPayInfo payInfo;
    // 担保确认订单
    private List<SecuredQueryAcceptInfo> acceptInfo;
    // 担保退款订单
    private List<SecuredQueryRefundInfo> refundInfo;
}
