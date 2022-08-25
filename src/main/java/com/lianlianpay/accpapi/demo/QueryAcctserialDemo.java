package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.query.AcctserialParams;
import com.lianlianpay.accpapi.v1.acctmgr.query.AcctserialResult;

/**
 * 资金流水列表查询 Demo
 */
public class QueryAcctserialDemo {
    public static void main(String[] args) {
        AcctserialParams params = new AcctserialParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("verify-code0ddfb801-8c34-45c4-854d-81834bc27deb");
        /*
        用户类型。
        INNERMERCHANT:商户
        INNERUSER：个人用户
        INNERCOMPANY：企业用户
         */
        params.setUser_type("INNERUSER");
        /*
        USEROWN_PSETTLE	用户自有待结算账户
        USEROWN_AVAILABLE	用户自有可用账户
         */
        params.setAcct_type("USEROWN_PSETTLE");
        params.setDate_start("20220824000000");
        params.setDate_end(timestamp);
        params.setPage_no("1");
        params.setPage_size("10");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/query-acctserial";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        AcctserialResult acctserialResult = JSON.parseObject(resultJsonStr, AcctserialResult.class);
        System.out.println(acctserialResult);
    }
}
