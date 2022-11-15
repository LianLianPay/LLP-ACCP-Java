package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.find.FindPasswordApplyParams;
import com.lianlianpay.accpapi.v1.acctmgr.find.FindPasswordApplyResult;
import com.lianlianpay.accpapi.v1.acctmgr.find.FindPasswordVerifyParams;
import com.lianlianpay.accpapi.v1.acctmgr.find.FindPasswordVerifyResult;

/**
 * 找回密码申请&验证 Demo
 */
public class FindPasswordDemo {
    public static void main(String[] args) {
        // 找回密码申请
        FindPasswordApplyParams params = new FindPasswordApplyParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-Api-User-12345abcd");
        // 绑定银行账号。个人用户绑定的银行卡号，若未绑卡，则不传。
        //params.setLinked_acctno("");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/find-password-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        FindPasswordApplyResult findPasswordApplyResult = JSON.parseObject(resultJsonStr, FindPasswordApplyResult.class);

        if ("0000".equals(findPasswordApplyResult.getRet_code())) {
            // 用Debug模式，断点打到这里，Debug的时候把verifyCode设置成手机收到的真实验证码
            // 验证码
            String verifyCode = "";
            // 与加密密文对应的随机因子random_key
            String randomKey = "";
            // 加密密文
            String password = "";

            // 找回密码验证
            FindPasswordVerifyParams verifyParams = new FindPasswordVerifyParams();
            verifyParams.setTimestamp(LLianPayDateUtils.getTimestamp());
            verifyParams.setOid_partner(LLianPayConstant.OidPartner);
            verifyParams.setUser_id(findPasswordApplyResult.getUser_id());
            verifyParams.setToken(findPasswordApplyResult.getToken());
            /*
            短信验证码。企业和个体工商户验证注册绑定手机号。
            个人验证银行预留手机号，未绑卡用户验证注册手机号。
             */
            verifyParams.setVerify_code(verifyCode);
            verifyParams.setRandom_key(randomKey);
            verifyParams.setPassword(password);

            // 测试环境URL
            String verifyUrl = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/find-password-verify";
            String resultJsonStr2 = new LLianPayClient().sendRequest(verifyUrl, JSON.toJSONString(verifyParams));
            FindPasswordVerifyResult findPasswordVerifyResult = JSON.parseObject(resultJsonStr2, FindPasswordVerifyResult.class);
            System.out.println(findPasswordVerifyResult);
        }
    }
}
