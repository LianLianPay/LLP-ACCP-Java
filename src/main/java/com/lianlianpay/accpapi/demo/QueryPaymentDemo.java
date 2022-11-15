package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.payment.QueryPaymentParams;
import com.lianlianpay.accpapi.v1.txn.payment.QueryPaymentResult;

/**
 * 支付结果查询 Demo
 */
public class QueryPaymentDemo {
    public static void main(String[] args) {
        QueryPaymentParams params = new QueryPaymentParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        // ACCP系统交易单号。【三选一】，建议优先使用ACCP系统交易单号
        params.setAccp_txno("2022111417141745");

        LLianPayClient lLianPayClient = new LLianPayClient();
        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/query-payment";
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        QueryPaymentResult queryPaymentResult = JSON.parseObject(resultJsonStr, QueryPaymentResult.class);
        System.out.println(queryPaymentResult);
    }
}
