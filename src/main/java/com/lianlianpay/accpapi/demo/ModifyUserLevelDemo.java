package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.individual.*;

/**
 * 用户等级修改 Demo
 */
public class ModifyUserLevelDemo {
    public static void main(String[] args) {
        ModifyUserLevelParams params =new ModifyUserLevelParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-In-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);

        // 开户账户申请信息
        OpenacctApplyAccountInfo accountInfo = new OpenacctApplyAccountInfo();
        // 个人用户建议设置成个人支付账户类型
        accountInfo.setAccount_type("PERSONAL_PAYMENT_ACCOUNT");
        accountInfo.setAccount_need_level("V3");
        params.setAccountInfo(accountInfo);

        // 测试环境url
        String testurl = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/modify-user-level";
        // 生产环境url
        String url = "https://accpapi.lianlianpay.com/v1/acctmgr/modify-user-level";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        ModifyUserLevelResult modifyUserLevelResult = JSON.parseObject(resultJsonStr, ModifyUserLevelResult.class);
        System.out.println(modifyUserLevelResult);
    }
}
