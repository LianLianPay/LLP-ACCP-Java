package com.lianlianpay.accpapi.v1.txn.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 支付结果查询 响应参数
 */
@Data
@EqualsAndHashCode
public class QueryPaymentResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    /*
    交易类型。
    用户充值：USER_TOPUP
    商户充值：MCH_TOPUP
    普通消费：GENERAL_CONSUME
    担保消费：SECURED_CONSUME
    担保确认：SECURED_CONFIRM
    内部代发：INNER_FUND_EXCHANGE
    外部代发：OUTER_FUND_EXCHANGE
     */
    private String txn_type;
    // 账务日期
    private String accounting_date;
    // 支付完成时间
    private String finish_time;
    // ACCP系统交易单号
    private Double accp_txno;
    // 渠道交易单号
    private String chnl_txno;
    /*
    支付交易状态。
    TRADE_WAIT_PAY:交易处理中
    TRADE_SUCCESS:交易成功
    TRADE_CLOSE:交易失败
    支付交易状态以此为准，商户必须依据此字段值进行后续业务逻辑处理。
     */
    private String txn_status;
    // 商户订单信息
    private QueryPaymentOrderInfo orderInfo;
    // 付款方信息（组合支付场景返回付款方信息数组）
    private List<QueryPaymentPayerInfo> payerInfo;
    // 收款方信息（交易分账场景返回收款方信息数组）
    private List<QueryPaymentPayeeInfo> payeeInfo;
}
