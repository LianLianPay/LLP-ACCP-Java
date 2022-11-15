package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.unlinked.UnLinkedAcctIndApplyParams;
import com.lianlianpay.accpapi.v1.acctmgr.unlinked.UnLinkedAcctIndApplyResult;

/**
 * 个人用户解绑银行卡 Demo
 */
public class UnLinkedRegisteredAcctIndApplyDemo {
    public static void main(String[] args) {
        UnLinkedAcctIndApplyParams params = new UnLinkedAcctIndApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-Api-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setNotify_url("https://test.lianlianpay/notify");
        // 绑定银行账号
        params.setLinked_acctno("");
        // 用户：LLianPayTest-Api-User-12345 密码：qwerty，本地测试环境测试，没接入密码控件，使用本地加密方法加密密码（仅限测试环境使用）
        params.setPassword(LLianPayAccpSignature.getInstance().localEncrypt("qwerty"));

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/unlinkedacct-ind-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        UnLinkedAcctIndApplyResult unLinkedAcctIndApplyResult = JSON.parseObject(resultJsonStr, UnLinkedAcctIndApplyResult.class);
        System.out.println(unLinkedAcctIndApplyResult);
    }
}
