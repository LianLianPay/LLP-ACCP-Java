package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.OpenacctApplyAccountInfo;
import com.lianlianpay.accpapi.v1.acctmgr.OpenacctApplyParams;
import com.lianlianpay.accpapi.v1.acctmgr.OpenacctApplyResult;

/**
 * 用户开户申请(页面接入) Demo
 */
public class H5OpenacctDemo {
    public static void main(String[] args) {
        innerUser();
        //enterprise();
    }

    /**
     * 企业用户（页面）开户 Demo
     */
    public static void enterprise() {
        OpenacctApplyParams params = new OpenacctApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-En-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        /*
        交易发起渠道。
        ANDROID
        IOS
        H5
        PC
         */
        params.setFlag_chnl("H5");
        // 交易完成回跳页面地址，H5/PC渠道必传。
        params.setReturn_url("https://open.lianlianpay.com?jump=page");
        // 交易结果异步通知接收地址，建议HTTPS协议。
        params.setNotify_url("https://test.lianlianpay/notify");
        /*
        用户类型。
        INNERUSER：个人用户
        INNERCOMPANY：企业用户
         */
        params.setUser_type("INNERCOMPANY");

        // 设置开户账户申请信息
        OpenacctApplyAccountInfo accountInfo = new OpenacctApplyAccountInfo();
        /*
        个人支付账户  PERSONAL_PAYMENT_ACCOUNT
        企业支付账户  ENTERPRISE_PAYMENT_ACCOUNT
         */
        accountInfo.setAccount_type("ENTERPRISE_PAYMENT_ACCOUNT");
        //accountInfo.setAccount_need_level("V3");
        params.setAccountInfo(accountInfo);

        // 测试环境请求地址
        String url = "https://accpgw-ste.lianlianpay-inc.com/v1/acctmgr/openacct-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        OpenacctApplyResult openacctApplyResult = JSON.parseObject(resultJsonStr, OpenacctApplyResult.class);
        System.out.println(openacctApplyResult);
    }

    /**
     * 个人用户（页面）开户 Demo
     */
    public static void innerUser() {
        OpenacctApplyParams params = new OpenacctApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-In-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        /*
        交易发起渠道。
        ANDROID
        IOS
        H5
        PC
         */
        params.setFlag_chnl("H5");
        // 交易完成回跳页面地址，H5/PC渠道必传。
        params.setReturn_url("https://open.lianlianpay.com?jump=page");
        // 交易结果异步通知接收地址，建议HTTPS协议。
        params.setNotify_url("https://test.lianlianpay/notify");
        /*
        用户类型。
        INNERUSER：个人用户
        INNERCOMPANY：企业用户
         */
        params.setUser_type("INNERUSER");

        // 设置开户账户申请信息
        OpenacctApplyAccountInfo accountInfo = new OpenacctApplyAccountInfo();
        /*
        个人支付账户  PERSONAL_PAYMENT_ACCOUNT
        企业支付账户  ENTERPRISE_PAYMENT_ACCOUNT
         */
        accountInfo.setAccount_type("PERSONAL_PAYMENT_ACCOUNT");
        accountInfo.setAccount_need_level("V3");
        params.setAccountInfo(accountInfo);

        // 测试环境URL
        String url = "https://accpgw-ste.lianlianpay-inc.com/v1/acctmgr/openacct-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        OpenacctApplyResult openacctApplyResult = JSON.parseObject(resultJsonStr, OpenacctApplyResult.class);
        System.out.println(openacctApplyResult);
    }
}
