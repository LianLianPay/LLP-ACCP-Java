package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.query.AcctserialDetailParams;
import com.lianlianpay.accpapi.v1.acctmgr.query.AcctserialDetailResult;

/**
 * 资金流水详情查询 Demo
 * 需要和资金流水列表查询配合使用
 */
public class QueryAcctserialDetailDemo {
    public static void main(String[] args) {
        AcctserialDetailParams params = new AcctserialDetailParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("verify-code0ddfb801-8c34-45c4-854d-81834bc27deb");
        /*
        用户类型。
        INNERMERCHANT:商户
        INNERUSER：个人用户
        INNERCOMPANY：企业用户
         */
        params.setUser_type("INNERUSER");
        // 资金流水列表查询返回的jno_acct
        params.setJno_acct("20220824000004471563");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/query-acctserialdetail";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        AcctserialDetailResult acctserialDetailResult = JSON.parseObject(resultJsonStr, AcctserialDetailResult.class);
        System.out.println(acctserialDetailResult);
    }
}
