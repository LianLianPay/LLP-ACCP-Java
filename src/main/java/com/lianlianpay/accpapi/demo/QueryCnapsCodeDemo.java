package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.cnapscode.QueryParams;
import com.lianlianpay.accpapi.v1.acctmgr.cnapscode.QueryResult;

/**
 * 大额行号查询 Demo
 */
public class QueryCnapsCodeDemo {
    public static void main(String[] args) {
        QueryParams params = new QueryParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTimestamp(timestamp);
        params.setBank_code("01030000");
        params.setBrabank_name("行");
        params.setCity_code("330100");

        // 测试环境请求地址
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/query-cnapscode";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        QueryResult queryResult = JSON.parseObject(resultJsonStr, QueryResult.class);
        System.out.println(queryResult);
    }
}
