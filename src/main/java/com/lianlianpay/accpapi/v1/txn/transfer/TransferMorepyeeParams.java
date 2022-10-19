package com.lianlianpay.accpapi.v1.txn.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 内部代发申请 请求参数
 */
@Data
@EqualsAndHashCode
public class TransferMorepyeeParams {
    private String timestamp;
    private String oid_partner;
    private String notify_url;
    /*
    垫资标识。标识该笔代发交易是否支持平台商户垫资，适用于代发付款方为用户的业务场景。
    默认：N
    Y：支持垫资
    N：不支持垫资
     */
    private String funds_flag;
    /*
    定向支付标识。
    标识该笔代发交易是否是约定收款方的定向支付，默认：N。
    Y：定向支付
    N：普通支付
     */
    private String directionalpay_flag;
    /*
    连续代发标识。
    标识该笔代发交易是否是连续代发，默认：N
    Y：连续代发
    N：普通代发
    默认为N，如平台开通连续代发权限时，可以传入Y。
    有效期30分钟，连续代发期间免密免验，超过需要再次验证。
     */
    private String continuously_flag;
    private String risk_item;
    // 商户订单信息
    private TransferMorepyeeOrderInfo orderInfo;
    // 付款方信息
    private TransferMorepyeePayerInfo payerInfo;
    // 收款方信息
    private List<TransferMorepyeePayeeInfo> payeeInfo;
}
