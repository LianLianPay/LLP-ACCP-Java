package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.secured.SecuredQueryParams;
import com.lianlianpay.accpapi.v1.txn.secured.SecuredQueryResult;

/**
 * 担保交易信息查询 Demo
 */
public class SecuredQueryDemo {
    public static void main(String[] args) {
        SecuredQueryParams params = new SecuredQueryParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno("202302071352032021805645");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/secured-query";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        SecuredQueryResult securedQueryResult = JSON.parseObject(resultJsonStr, SecuredQueryResult.class);
        System.out.println(securedQueryResult);
    }
}
