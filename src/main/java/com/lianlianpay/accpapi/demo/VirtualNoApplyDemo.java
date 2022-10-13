package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.virtualno.VirtualInfo;
import com.lianlianpay.accpapi.v1.acctmgr.virtualno.VirtualNoApplyParams;
import com.lianlianpay.accpapi.v1.acctmgr.virtualno.VirtualNoApplyResult;

/**
 * 虚拟卡申请 Demo
 */
public class VirtualNoApplyDemo {
    public static void main(String[] args) {
        VirtualNoApplyParams params = new VirtualNoApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);

        // 虚拟卡参数
        VirtualInfo virtualInfo = new VirtualInfo();
        /*
        所属客户类型。
        用户：USER
        平台商户：MERCHANT
         */
        virtualInfo.setCust_type("USER");
        // 申请虚拟卡的请求方ID，若为消费类虚拟卡，则必填。
        virtualInfo.setUser_id("LLianPayTest-In-User-12345");
        virtualInfo.setApply_userid("LLianPayTest-In-User-12345-afafafd");
        // 申请虚拟卡的客户姓名。会尝试检查通过虚拟卡转账的他行卡户名是否一致。
        virtualInfo.setApply_username("个人开户测试");
        /*
        申请虚拟卡场景。消费：consume
        现金上缴：deposit_cash
        费用上缴：deposit_fee
        其他：other
        （payee_id+applay_userid+apply_sence只能一张卡）
         */
        virtualInfo.setApply_sence("consume");
        /*
        虚拟卡业务类型。
        消费业务：OFFLINE_CONSUME
         */
        virtualInfo.setBussiness_type("OFFLINE_CONSUME");
        // 虚拟卡入账通知URL
        virtualInfo.setBboc_notify("https://test.lianlianpay/notify");
        params.setVirtualInfo(virtualInfo);

        // 测试环境虚拟卡申请URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/virtualno-apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        VirtualNoApplyResult virtualNoApplyResult = JSON.parseObject(resultJsonStr, VirtualNoApplyResult.class);
        System.out.println(virtualNoApplyResult);

    }
}
