package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.password.ApplyPasswordElementParams;
import com.lianlianpay.accpapi.v1.acctmgr.password.ApplyPasswordElementResult;

/**
 * 申请密码控件Token Demo
 */
public class ApplyPasswordElementDemo {
    public static void main(String[] args) {
        ApplyPasswordElementParams params = new ApplyPasswordElementParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno("LLianPayTest" + timestamp);
        /*
        密码使用场景：
        设置密码：setting_password
        修改密码：change_password
        换绑卡：bind_card_password
        提现密码：cashout_password
        支付密码：pay_password
         */
        params.setPassword_scene("setting_password");
        params.setFlag_chnl("H5");

        String url = "https://accpgw-ste.lianlianpay-inc.com/v1/acctmgr/apply-password-element";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        ApplyPasswordElementResult applyPasswordElementResult = JSON.parseObject(resultJsonStr, ApplyPasswordElementResult.class);
        System.out.println(applyPasswordElementResult);
    }
}
