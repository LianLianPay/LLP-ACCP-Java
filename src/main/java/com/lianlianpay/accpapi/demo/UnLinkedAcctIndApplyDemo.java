package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v2.acctmgr.UnLinkedAcctIndApplyParams;
import com.lianlianpay.accpapi.v2.acctmgr.UnLinkedAcctIndApplyResult;

/**
 * 匿名用户解绑银行卡 Demo
 */
public class UnLinkedAcctIndApplyDemo {
    public static void main(String[] args) {
        UnLinkedAcctIndApplyParams params = new UnLinkedAcctIndApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-An-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setNotify_url("https://test.lianlianpay/notify");
        // 绑定银行账号。该字段需要RSA公钥加密传输
        params.setLinked_acctno(LLianPayAccpSignature.getInstance().localEncrypt(""));

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v2/acctmgr/unlinkedacct-ind-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        UnLinkedAcctIndApplyResult unLinkedAcctIndApplyResult = JSON.parseObject(resultJsonStr, UnLinkedAcctIndApplyResult.class);
        System.out.println(unLinkedAcctIndApplyResult);
    }
}
