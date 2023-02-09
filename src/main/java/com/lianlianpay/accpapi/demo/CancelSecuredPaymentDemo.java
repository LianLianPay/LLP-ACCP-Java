package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.secured.CancelSecuredPaymentParams;
import com.lianlianpay.accpapi.v1.txn.secured.CancelSecuredPaymentResult;

/**
 * 担保确认撤销 Demo
 */
public class CancelSecuredPaymentDemo {
    public static void main(String[] args) {
        CancelSecuredPaymentParams params = new CancelSecuredPaymentParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno("LLianPayTest20230110124354");

        // 测试环境请求地址
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/cancel-secured-payment";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        CancelSecuredPaymentResult cancelSecuredPaymentResult = JSON.parseObject(resultJsonStr, CancelSecuredPaymentResult.class);
        System.out.println(cancelSecuredPaymentResult);
    }
}
