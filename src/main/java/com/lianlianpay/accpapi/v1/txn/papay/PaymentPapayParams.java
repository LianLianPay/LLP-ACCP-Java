package com.lianlianpay.accpapi.v1.txn.papay;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 委托代扣 请求参数
 */
@Data
@EqualsAndHashCode
public class PaymentPapayParams {
    private String timestamp;
    private String oid_partner;
    /*
    交易类型。
    用户充值：USER_TOPUP
    商户充值：MCH_TOPUP
    普通消费：GENERAL_CONSUME
    担保消费：SECURED_CONSUME
     */
    private String txn_type;
    private String user_id;
    /*
    用户类型。默认：注册用户。
    注册用户：REGISTERED
    匿名用户：ANONYMOUS
     */
    private String user_type;
    private String notify_url;
    private String return_url;
    private String appid;
    private String client_ip;
    private String risk_item;
    // 商户订单信息
    private PaymentPapayOrderInfo orderInfo;
    // 付款方信息
    private PaymentPapayPayerInfo payerInfo;
    // 付款方式信息
    private PaymentPapayPayMethod payMethods;
    // 收款方信息
    private PaymentPapayPayeeInfo payeeInfo;
    // 微信附加字段
    private WechatInfo wechatInfo;
    // 支付宝附加字段
    private AlipayInfo alipayInfo;
}
