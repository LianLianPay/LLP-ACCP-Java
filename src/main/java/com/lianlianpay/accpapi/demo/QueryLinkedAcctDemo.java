package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.query.QueryLinkedAcctParams;
import com.lianlianpay.accpapi.v1.acctmgr.query.QueryLinkedAcctResult;

/**
 * 绑卡信息查询 Demo
 */
public class QueryLinkedAcctDemo {
    public static void main(String[] args) {
        QueryLinkedAcctParams params = new QueryLinkedAcctParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-In-User-12345");

        // 测试环境请求地址
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/query-linkedacct";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        QueryLinkedAcctResult queryLinkedAcctResult = JSON.parseObject(resultJsonStr, QueryLinkedAcctResult.class);
        System.out.println(queryLinkedAcctResult);
    }
}
