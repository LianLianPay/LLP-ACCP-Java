package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.refund.*;

import java.util.Arrays;

/**
 * 退款申请 Demo
 */
public class MorePayeeRefundDemo {
    public static void main(String[] args) {
        MorePayeeRefundParams params = new MorePayeeRefundParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        // 原交易付款方user_id
        params.setUser_id("LLianPayTest-In-User-12345abdfasjdlf");

        // 原商户订单信息
        OriginalOrderInfo originalOrderInfo = new OriginalOrderInfo();
        // 原支付交易商户系统唯一交易流水号
        originalOrderInfo.setTxn_seqno("LLianPayTest20221107113358");
        // 订单总金额
        originalOrderInfo.setTotal_amount(150.0);
        params.setOriginalOrderInfo(originalOrderInfo);

        // 退款订单信息
        RefundOrderInfo refundOrderInfo = new RefundOrderInfo();
        // 退款订单号。标识一次退款请求，商户系统需要保证唯一
        refundOrderInfo.setRefund_seqno("LLianPayTest" + timestamp);
        refundOrderInfo.setRefund_time(timestamp);
        // 退款总金额。本次需要退款的金额，不允许超过对应原收款方的收款金额
        refundOrderInfo.setRefund_amount(1.0);
        params.setRefundOrderInfo(refundOrderInfo);

        // 原收款方退款信息
        PyeeRefundInfo pyeeRefundInfo = new PyeeRefundInfo();
        // 原收款方id，本次退款需要处理的原交易收款方id
        pyeeRefundInfo.setPayee_id("LLianPayTest-En-User-12345");
        /*
        原收款方类型。
        用户：USER
        平台商户：MERCHANT
         */
        pyeeRefundInfo.setPayee_type("USER");
        /*
        原收款方账户类型。
        用户账户：USEROWN
        平台商户自有资金账户：MCHOWN
        平台商户担保账户：MCHASSURE
        平台商户优惠券账户：MCHCOUPON
        平台商户手续费账户：MCHFEE
         */
        pyeeRefundInfo.setPayee_accttype("USEROWN");
        // 退款金额。本次需要退款的金额，不允许超过对应原收款方的收款金额。
        pyeeRefundInfo.setPayee_refund_amount(1.0);
        // 垫资标识。当原收款方金额不足时，是否由平台垫资的标识，默认:N
        pyeeRefundInfo.setIs_advance_pay("N");
        params.setPyeeRefundInfos(Arrays.asList(new PyeeRefundInfo[]{pyeeRefundInfo}));

        // 原付款方式退款规则信息
        RefundMethod refundMethod = new RefundMethod();
        // 付款方式
        refundMethod.setMethod("EBANK_B2B");
        // 退款金额
        refundMethod.setAmount(1.0);
        params.setRefundMethods(Arrays.asList(new RefundMethod[]{refundMethod}));

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/more-payee-refund";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        MorePayeeRefundResult morePayeeRefundResult = JSON.parseObject(resultJsonStr, MorePayeeRefundResult.class);
        System.out.println(morePayeeRefundResult);
    }
}
