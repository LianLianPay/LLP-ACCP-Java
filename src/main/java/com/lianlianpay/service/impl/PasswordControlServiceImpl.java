package com.lianlianpay.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.password.ApplyPasswordElementParams;
import com.lianlianpay.accpapi.v1.acctmgr.password.ApplyPasswordElementResult;
import com.lianlianpay.accpapi.v1.acctmgr.random.GetRandomParams;
import com.lianlianpay.accpapi.v1.acctmgr.random.GetRandomResult;
import com.lianlianpay.service.PasswordControlService;
import org.springframework.stereotype.Service;

@Service
public class PasswordControlServiceImpl implements PasswordControlService {
    @Override
    public String getRandom(String flagChnl) {
        GetRandomParams params = new GetRandomParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-In-User-12345");
        /*
        交易发起渠道。
        ANDROID
        IOS
        H5
        PC
         */
        params.setFlag_chnl(flagChnl);
        // 测试环境都传test，正式环境传真实域名/包名
        params.setPkg_name("test");
        // 测试环境都传test，正式环境传真实域名/应用名
        params.setApp_name("test");
        params.setEncrypt_algorithm("PCH5".equalsIgnoreCase(flagChnl) ? "SM2" : "RSA");

        LLianPayClient lLianPayClient = new LLianPayClient();
        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/get-random";
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        GetRandomResult randomResult = JSON.parseObject(resultJsonStr, GetRandomResult.class);

        // 构建前端需要的json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("license", randomResult.getLicense());
        jsonObject.put("map_arr", randomResult.getMap_arr() == null ? "" : randomResult.getMap_arr());
        jsonObject.put("random_key", randomResult.getRandom_key());
        jsonObject.put("random_value", randomResult.getRandom_value());
        jsonObject.put("rsa_public_content", randomResult.getRsa_public_content() == null ? "" : randomResult.getRsa_public_content());
        jsonObject.put("oid_partner", randomResult.getOid_partner());
        jsonObject.put("sm2_key_hex", randomResult.getSm2_key_hex() == null ? "" : randomResult.getSm2_key_hex());
        jsonObject.put("user_id", randomResult.getUser_id());
        return jsonObject.toJSONString();
    }

    @Override
    public String getPasswordElementToken() {
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
        ApplyPasswordElementResult result = JSON.parseObject(resultJsonStr, ApplyPasswordElementResult.class);

        // 构建前端需要的json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("passwordScene", params.getPassword_scene());
        jsonObject.put("oidPartner", result.getOid_partner());
        jsonObject.put("userId", params.getUser_id());
        jsonObject.put("passwordElementToken", result.getPassword_element_token());
        return jsonObject.toJSONString();
    }
}
