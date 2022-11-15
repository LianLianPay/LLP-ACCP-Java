package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.cancel.CancelApplyParams;
import com.lianlianpay.accpapi.v1.acctmgr.cancel.CancelApplyResult;

/**
 * 销户申请 Demo
 */
public class CancelApplyDemo {
    public static void main(String[] args) {
        CancelApplyParams params = new CancelApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-Api-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setNotify_url("https://test.lianlianpay/notify");
        // 用户名称。企业用户传企业名称，个体工商户传营业执照的名称（营业执照上名称是****或者无的，传经营者姓名），个人用户传姓名。
        params.setUser_name("API开户测试");
        /*
        证件类型。
        身份证：ID_CARD
        统一社会信用代码证：UNIFIED_SOCIAL_CREDIT_CODE。
         */
        params.setId_type("ID_CARD");
        // 证件号码。 对应id_type的相关证件号码
        params.setId_no("");
        // 绑定手机号。用户开户注册绑定手机号。
        params.setReg_phone("");
        // 用户：LLianPayTest-Api-User-12345 密码：qwerty，本地测试环境测试，没接入密码控件，使用本地加密方法加密密码（仅限测试环境使用）
        params.setPassword(LLianPayAccpSignature.getInstance().localEncrypt("qwerty"));

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/cancel-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        CancelApplyResult cancelApplyResult = JSON.parseObject(resultJsonStr, CancelApplyResult.class);
        System.out.println(cancelApplyResult);
    }
}
