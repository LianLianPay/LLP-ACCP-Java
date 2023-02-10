package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.*;

/**
 * 提现申请 Demo
 */
public class WithDrawalDemo {
    public static void main(String[] args) {
        WithDrawalParams params = new WithDrawalParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setNotify_url("https://test.lianlianpay/notify");
        params.setLinked_agrtno("2022081900364011");

        // 设置商户订单信息
        WithDrawalOrderInfo orderInfo = new WithDrawalOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(150.00);
        orderInfo.setPostscript("用户提现");
        params.setOrderInfo(orderInfo);

        // 设置付款方信息
        WithDrawalPayerInfo payerInfo = new WithDrawalPayerInfo();
        payerInfo.setPayer_type("USER");
        payerInfo.setPayer_id("LLianPayTest-In-User-12345");
        // 用户：LLianPayTest-In-User-12345 密码：qwerty，本地测试环境测试，没接入密码控件，使用本地加密方法加密密码（仅限测试环境使用）
        payerInfo.setPassword(LLianPayAccpSignature.getInstance().localEncrypt("qwerty"));
        params.setPayerInfo(payerInfo);
        params.setRisk_item("{\"frms_ware_category\":\"4007\",\"goods_name\":\"测试商品\",\"user_info_mercht_userno\":\"" + payerInfo.getPayer_id() + "\",\"user_info_dt_register\":\"20220823101239\",\"user_info_bind_phone\":\"13308123456\",\"user_info_full_name\":\"连连测试\",\"user_info_id_no\":\"123456789012345678\",\"user_info_identify_state\":\"0\",\"user_info_identify_type\":\"4\",\"user_info_id_type\":\"0\",\"frms_client_chnl\":\" 16\",\"frms_ip_addr\":\"127.0.0.1\",\"user_auth_flag\":\"1\"}");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/withdrawal";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        WithDrawalResult drawalResult = JSON.parseObject(resultJsonStr, WithDrawalResult.class);

        // 小额免验，不需要验证码，直接返回0000
        if ("0000".equals(drawalResult.getRet_code())) {
            System.out.println("支付成功！！！");
            return;
        }
        // 需要输入短信验证码，调用交易二次短信验证接口
        // 用Debug模式，断点打到这里，Debug的时候把verifyCode设置成手机收到的真实验证码
        String verifyCode = "";
        if ("8888".equals(drawalResult.getRet_code())) {
            ValidationSmsParams validationSmsParams = new ValidationSmsParams();
            validationSmsParams.setTimestamp(LLianPayDateUtils.getTimestamp());
            validationSmsParams.setOid_partner(drawalResult.getOid_partner());
            validationSmsParams.setPayer_id(drawalResult.getUser_id());
            validationSmsParams.setPayer_type("USER");
            validationSmsParams.setTxn_seqno(drawalResult.getTxn_seqno());
            validationSmsParams.setTotal_amount(drawalResult.getTotal_amount().toString());
            validationSmsParams.setToken(drawalResult.getToken());
            validationSmsParams.setVerify_code(verifyCode);

            // 测试环境URL
            String validationSmsUrl = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/validation-sms";
            String resultJsonStr2 = lLianPayClient.sendRequest(validationSmsUrl, JSON.toJSONString(validationSmsParams));
            ValidationSmsResult validationSmsResult = JSON.parseObject(resultJsonStr2, ValidationSmsResult.class);
            System.out.println(validationSmsResult);
        }
    }
}
