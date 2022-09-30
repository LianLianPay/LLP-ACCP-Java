package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.individual.IndividualModifyUserInfoBasicInfo;
import com.lianlianpay.accpapi.v1.acctmgr.individual.IndividualModifyUserInfoParams;
import com.lianlianpay.accpapi.v1.acctmgr.individual.IndividualModifyUserInfoResult;

/**
 * 个人用户信息修改 Demo
 */
public class IndividualModifyUserInfoDemo {
    public static void main(String[] args) {
        IndividualModifyUserInfoParams params = new IndividualModifyUserInfoParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-Api-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setNotify_url("https://test.lianlianpay/notify");

        IndividualModifyUserInfoBasicInfo basicInfo = new IndividualModifyUserInfoBasicInfo();
        basicInfo.setId_emblem("202209010003370005");
        basicInfo.setId_portrait("202209010003370005");
        params.setBasicInfo(basicInfo);

        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/modify-userinfo-individual";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        IndividualModifyUserInfoResult individualModifyUserInfoResult = JSON.parseObject(resultJsonStr, IndividualModifyUserInfoResult.class);
        System.out.println(individualModifyUserInfoResult);
    }
}
