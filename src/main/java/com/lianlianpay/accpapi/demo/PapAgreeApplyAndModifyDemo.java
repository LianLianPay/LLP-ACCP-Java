package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.PapAgreeApplyAndModifyParams;
import com.lianlianpay.accpapi.v1.txn.PapAgreeResult;
import com.lianlianpay.accpapi.v1.txn.PapAgreeSignInfo;

/**
 * 用户委托协议申请/修改 Demo
 */
public class PapAgreeApplyAndModifyDemo {
    public static void main(String[] args) {
//        apply();
        modify();
    }

    /**
     * 用户委托协议申请
     */
    public static void apply() {
        PapAgreeApplyAndModifyParams params = new PapAgreeApplyAndModifyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setUser_id("LLianPayTest-In-User-12345");
        params.setFlag_chnl("H5");
        params.setNotify_url("https://test.lianlianpay/notify");
        params.setReturn_url("https://open.lianlianpay.com?jump=page");

        // 设置签约信息
        PapAgreeSignInfo papAgreeSignInfo = new PapAgreeSignInfo();
        papAgreeSignInfo.setSign_start_time("20221001");
        papAgreeSignInfo.setSign_invalid_time("20231001");
        papAgreeSignInfo.setSingle_limit(100.00);
        papAgreeSignInfo.setDaily_limit(1000.00);
        papAgreeSignInfo.setMonthly_limit(5000.00);
        /*
        免密协议类型。
        WITH_HOLD：免密代扣
        WITH_WITHDRAW：免密提现
        注：若不填写，则默认为免密代扣。
         */
        papAgreeSignInfo.setAgreement_type("WITH_HOLD");
        params.setPapSignInfo(papAgreeSignInfo);

        // 测试环境URL
        String url = "https://accpgw-ste.lianlianpay-inc.com/v1/txn/pap-agree-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        PapAgreeResult papAgreeResult = JSON.parseObject(resultJsonStr, PapAgreeResult.class);
        System.out.println(papAgreeResult);
    }

    /**
     * 用户委托协议修改
     */
    public static void modify() {
        PapAgreeApplyAndModifyParams params = new PapAgreeApplyAndModifyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setUser_id("LLianPayTest-In-User-12345");
        params.setPap_agree_no("2022093000265008");
        params.setFlag_chnl("H5");
        params.setNotify_url("https://test.lianlianpay/notify");
        params.setReturn_url("https://open.lianlianpay.com?jump=page");

        // 设置签约信息
/*        PapAgreeSignInfo papAgreeSignInfo = new PapAgreeSignInfo();
        papAgreeSignInfo.setSign_start_time("20221001");
        papAgreeSignInfo.setSign_invalid_time("20231001");
        papAgreeSignInfo.setSingle_limit(100.00);
        papAgreeSignInfo.setDaily_limit(1000.00);
        papAgreeSignInfo.setMonthly_limit(5000.00);
        *//*
        免密协议类型。
        WITH_HOLD：免密代扣
        WITH_WITHDRAW：免密提现
        注：若不填写，则默认为免密代扣。
         *//*
        papAgreeSignInfo.setAgreement_type("WITH_HOLD");
        params.setPapSignInfo(papAgreeSignInfo);*/

        // 测试环境URL
        String url = "https://accpgw-ste.lianlianpay-inc.com/v1/txn/pap-agree-modify";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        PapAgreeResult papAgreeResult = JSON.parseObject(resultJsonStr, PapAgreeResult.class);
        System.out.println(papAgreeResult);
    }
}
