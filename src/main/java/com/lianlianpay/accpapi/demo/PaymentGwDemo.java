package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.*;

/**
 * 网关类支付 Demo
 */
public class PaymentGwDemo {
    public static void main(String[] args) {
        TradeCreateResult tradeCreateResult = TradeCreateDemo.generalConsume();
        String timestamp = LLianPayDateUtils.getTimestamp();
        PaymentGwParams params = new PaymentGwParams();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno(tradeCreateResult.getTxn_seqno());
        params.setTotal_amount(tradeCreateResult.getTotal_amount());
        params.setRisk_item("{\"user_info_mercht_userno\":\"" + tradeCreateResult.getUser_id() + "\"}");

        // 终端用户IP。支持IPV4和IPV6两种格式的IP地址。
        // 正式环境传用户真实的IP
        params.setClient_ip("127.0.0.1");
        // 银行编码。付款方式为网银类时可指定。
        //params.setBankcode("01040000");

        PaymentPayerInfo payerInfo = new PaymentPayerInfo();
        payerInfo.setPayer_type("USER");
        payerInfo.setPayer_id(tradeCreateResult.getUser_id());
        params.setPayerInfo(payerInfo);

        PaymentBankCardPayMethods payMethods = new PaymentBankCardPayMethods();
        // 企业网银
        payMethods.setMethod("EBANK_B2B");
        payMethods.setAmount(tradeCreateResult.getTotal_amount());
        params.setPayMethods(new PaymentBankCardPayMethods[]{payMethods});

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/payment-gw";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        PaymentGwResult paymentResult = JSON.parseObject(resultJsonStr, PaymentGwResult.class);
        System.out.println(paymentResult);
    }
}
