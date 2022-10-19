package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.enterprise.ModifyUserInfoParams;
import com.lianlianpay.accpapi.v1.acctmgr.enterprise.ModifyUserInfoResult;
import com.lianlianpay.accpapi.v1.acctmgr.enterprise.OpenacctApplyBasicInfo;
import com.lianlianpay.accpapi.v1.acctmgr.enterprise.OpenacctApplyUboInfos;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业用户信息修改 Demo
 */
public class EnterpriseModifyUserInfoDemo {
    public static void main(String[] args) {
        ModifyUserInfoParams params = new ModifyUserInfoParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-En-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        // 交易结果异步通知接收地址，建议HTTPS协议。
        params.setNotify_url("https://test.lianlianpay/notify");

        // 基本信息更新
        OpenacctApplyBasicInfo basicInfo = new OpenacctApplyBasicInfo();
        basicInfo.setId_exp("99991231");
        basicInfo.setReg_email("158@163.com");
        //params.setBasicInfo(basicInfo);

        // 已有受益所有人信息替换
        OpenacctApplyUboInfos uboInfos = new OpenacctApplyUboInfos();
        uboInfos.setUbo_name("测试");
        uboInfos.setUbo_name_en("ceshi");
        uboInfos.setUbo_phone("");
        uboInfos.setId_type("ID_CARD");
        uboInfos.setId_no("");
        uboInfos.setId_emblem("");
        uboInfos.setId_portrait("");
//        uboInfos.setUnified_code();
        uboInfos.setId_exp("20301010");
//        uboInfos.setId_issue();
        uboInfos.setAddress("AAA");
//        uboInfos.setUbo_evidence();
        uboInfos.setUbo_type("ubo");
        List<OpenacctApplyUboInfos> list = new ArrayList<>();
        list.add(uboInfos);
        params.setUboInfos(list);

        // 测试环境请求地址
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/modify-userinfo-enterprise";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        ModifyUserInfoResult modifyUserInfoResult = JSON.parseObject(resultJsonStr, ModifyUserInfoResult.class);
        System.out.println(modifyUserInfoResult);
    }
}
