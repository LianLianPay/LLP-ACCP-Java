package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.query.UserInfoParams;
import com.lianlianpay.accpapi.v1.acctmgr.query.UserInfoResult;

/**
 * 资金流水列表查询 Demo
 */
public class QueryUserInfoDemo {
    public static void main(String[] args) {
        UserInfoParams params = new UserInfoParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("bdb1dd105679979ca82b28edd1c8ccd2");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/query-userinfo";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        UserInfoResult userInfoResult = JSON.parseObject(resultJsonStr, UserInfoResult.class);
        System.out.println(userInfoResult);
    }
}
