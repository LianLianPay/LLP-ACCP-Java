package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.close.ClosePaymentParams;
import com.lianlianpay.accpapi.v1.acctmgr.close.ClosePaymentResult;

/**
 * 支付单关单 Demo
 */
public class ClosePaymentDemo {
    public static void main(String[] args) {
        ClosePaymentParams params = new ClosePaymentParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setAccp_txno("2022082716141713");

        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/close-payment";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        ClosePaymentResult closePaymentResult = JSON.parseObject(resultJsonStr, ClosePaymentResult.class);
        System.out.println(closePaymentResult);
    }
}
