package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.random.GetRandomParams;
import com.lianlianpay.accpapi.v1.acctmgr.random.GetRandomResult;

/**
 * 随机因子获取 Demo
 */
public class GetRandomDemo {
    public static void main(String[] args) {
        GetRandomParams params = new GetRandomParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-In-User-12345");
        /*
        交易发起渠道。
        ANDROID
        IOS
        H5
        PC
         */
        params.setFlag_chnl("H5");
        // 测试环境都传test，正式环境传真实域名/包名
        params.setPkg_name("test");
        // 测试环境都传test，正式环境传真实域名/应用名
        params.setApp_name("test");
        params.setEncrypt_algorithm("RSA");

        LLianPayClient lLianPayClient = new LLianPayClient();
        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/get-random";
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        GetRandomResult getRandomResult = JSON.parseObject(resultJsonStr, GetRandomResult.class);
        System.out.println(getRandomResult);
    }
}
