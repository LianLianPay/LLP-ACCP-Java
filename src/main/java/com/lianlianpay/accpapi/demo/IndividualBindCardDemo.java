package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.individual.IndividualBindCardApplyParams;
import com.lianlianpay.accpapi.v1.acctmgr.individual.IndividualBindCardApplyResult;
import com.lianlianpay.accpapi.v1.acctmgr.individual.IndividualBindCardVerifyParams;
import com.lianlianpay.accpapi.v1.acctmgr.individual.IndividualBindCardVerifyResult;

/**
 * 个人用户新增绑卡 Demo
 */
public class IndividualBindCardDemo {
    public static void main(String[] args) {
        LLianPayClient lLianPayClient = new LLianPayClient();
        // 绑卡申请
        IndividualBindCardApplyResult bindCardApplyResult = bindCardApply(lLianPayClient);
        // 绑卡验证
        if (!"0000".equals(bindCardApplyResult.getRet_code())) {
            System.out.println("绑卡申请失败，请检查！");
            return;
        }
        bindCardVerify(lLianPayClient, bindCardApplyResult);
    }

    /**
     * 个人用户新增绑卡申请
     * @param lLianPayClient
     * @return
     */
    public static IndividualBindCardApplyResult bindCardApply(LLianPayClient lLianPayClient) {
        IndividualBindCardApplyParams params = new IndividualBindCardApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-Api-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setNotify_url("https://test.lianlianpay/notify");
        // 设置银行卡号
        params.setLinked_acctno("");
        // 设置绑卡手机号
        params.setLinked_phone("");
        // 设置钱包密码，正式环境要接密码控件，调试API可以用连连公钥加密密码
        params.setPassword(LLianPayAccpSignature.getInstance().localEncrypt(""));

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/individual-bindcard-apply";
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        IndividualBindCardApplyResult bindCardApplyResult = JSON.parseObject(resultJsonStr, IndividualBindCardApplyResult.class);
        return bindCardApplyResult;
    }

    /**
     * 个人用户新增绑卡验证
     * @param lLianPayClient
     * @param bindCardApplyResult
     */
    public static void bindCardVerify(LLianPayClient lLianPayClient, IndividualBindCardApplyResult bindCardApplyResult) {
        IndividualBindCardVerifyParams params = new IndividualBindCardVerifyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(bindCardApplyResult.getOid_partner());
        params.setUser_id(bindCardApplyResult.getUser_id());
        params.setTxn_seqno(bindCardApplyResult.getTxn_seqno());
        params.setToken(bindCardApplyResult.getToken());
        // 测试环境首次绑卡，不下发短信验证码，任意6位数字
        params.setVerify_code("123456");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/individual-bindcard-verify";
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        IndividualBindCardVerifyResult bindCardVerifyResult = JSON.parseObject(resultJsonStr, IndividualBindCardVerifyResult.class);
        System.out.println(bindCardVerifyResult);
    }
}
