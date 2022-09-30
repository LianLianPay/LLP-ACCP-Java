package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 网关类支付 请求参数
 */
@Data
@EqualsAndHashCode
public class PaymentGwParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private Double total_amount;
    private String risk_item;
    // 应用ID。开发者在微信或支付宝开放平台申请的APPID。非网银类，除扫码支付，都必传
    private String appid;
    // 渠道用户标识。微信公众号和微信小程序支付时必传。此参数为微信用户在商户对应APPID下的唯一标识或支付宝买家的支付宝唯一用户号
    private String openid;
    // 银行编码。付款方式为网银类时可指定。
    private String bankcode;
    // 设备标识。自定义参数，可以为终端设备号。
    private String device_info;
    // 终端用户IP。支持IPV4和IPV6两种格式的IP地址。
    private String client_ip;
    private String device_version;
    /*
    限制卡类型。限制某种卡类型支付权限，支付宝和微信支付都适用，若限制多种类型以“,”分隔（暂时只支持限制信用卡支付）。credit：限制适用信用卡支付。
     */
    private String limit_card_type;
    /*
    业务扩展字段。渠道扩展字段JSON串，若渠道为支付宝，则支持的键值对如下：
    sys_service_provider_id
    hb_fq_num
    hb_fq_seller_percent
    industry_reflux_info
    card_type
    支付宝微信同时支持键值：accp_sub_mch_id 子商户号
    微信H5扩展参数：req_domain 来源域名
     */
    private String extend_params;
    /*
    定向支付标识。
    标识该笔交易是否是约定收款方的定向支付，默认：N。
    Y：定向支付
    N：普通支付。
    组合余额支付场景时适用。
     */
    private String directionalpay_flag;
    // 付款方信息
    private PaymentPayerInfo payerInfo;
    // 付款方式信息
    private PaymentBankCardPayMethods[] payMethods;
}
