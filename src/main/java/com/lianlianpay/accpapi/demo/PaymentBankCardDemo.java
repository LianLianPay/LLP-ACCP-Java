package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.*;

/**
 * 银行卡快捷支付 Demo
 */
public class PaymentBankCardDemo {
    public static void main(String[] args) {
        // 调用统一支付创单接口进行创单
        TradeCreateResult tradeCreateResult = TradeCreateDemo.userTopup();
        // 使用银行卡快捷方式完成支付
        PaymentBankCardParams params = new PaymentBankCardParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(tradeCreateResult.getOid_partner());
        params.setTxn_seqno(tradeCreateResult.getTxn_seqno());
        params.setTotal_amount(tradeCreateResult.getTotal_amount());
        params.setRisk_item("{\"frms_ware_category\":\"4007\",\"goods_name\":\"西瓜\",\"user_info_mercht_userno\":\"LLianPayTest-In-User-12345\",\"user_info_dt_register\":\"20220823101239\",\"user_info_bind_phone\":\"13208123456\",\"user_info_full_name\":\"连连测试\",\"user_info_id_no\":\"\",\"user_info_identify_state\":\"0\",\"user_info_identify_type\":\"4\",\"user_info_id_type\":\"0\",\"frms_client_chnl\":\" H5\",\"frms_ip_addr\":\"127.0.0.1\",\"user_auth_flag\":\"1\"}");

        // 设置付款方信息
        PaymentPayerInfo payerInfo = new PaymentPayerInfo();
        payerInfo.setUser_id(tradeCreateResult.getUser_id());
        // 用户：LLianPayTest-In-User-12345 密码：qwerty，本地测试环境测试，没接入密码控件，使用本地加密方法加密密码（仅限测试环境使用）
        payerInfo.setPassword(LLianPayAccpSignature.getInstance().localEncrypt("qwerty"));
        params.setPayerInfo(payerInfo);

        // 设置付款银行卡信息
        PaymentBankCardInfo bankCardInfo = new PaymentBankCardInfo();
        // 使用该用户的绑卡协议号
        bankCardInfo.setLinked_agrtno("2022081900364011");
        params.setBankCardInfo(bankCardInfo);

        // 设置付款方式信息，支持组合支付，传入数组
        PaymentBankCardPayMethods payMethod = new PaymentBankCardPayMethods();
        // 协议支付借记卡
        payMethod.setMethod("AGRT_DEBIT_CARD");
        payMethod.setAmount(tradeCreateResult.getTotal_amount());
        params.setPayMethods(new PaymentBankCardPayMethods[]{payMethod});

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/payment-bankcard";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        PaymentBankCardResult bankCardResult = JSON.parseObject(resultJsonStr, PaymentBankCardResult.class);
        System.out.println(bankCardResult);

        // 小额免验，不需要验证码，直接返回0000
        if ("0000".equals(bankCardResult.getRet_code())) {
            System.out.println("支付成功！！！");
            return;
        }
        // 需要输入短信验证码，调用交易二次短信验证接口
        // 用Debug模式，断点打到这里，Debug的时候把verifyCode设置成手机收到的真实验证码
        String verifyCode = "";
        if ("8888".equals(bankCardResult.getRet_code())) {
            ValidationSmsParams validationSmsParams = new ValidationSmsParams();
            validationSmsParams.setTimestamp(LLianPayDateUtils.getTimestamp());
            validationSmsParams.setOid_partner(bankCardResult.getOid_partner());
            validationSmsParams.setPayer_id(bankCardResult.getUser_id());
            validationSmsParams.setPayer_type("USER");
            validationSmsParams.setTxn_seqno(bankCardResult.getTxn_seqno());
            validationSmsParams.setTotal_amount(bankCardResult.getTotal_amount().toString());
            validationSmsParams.setToken(bankCardResult.getToken());
            validationSmsParams.setVerify_code(verifyCode);

            // 测试环境URL
            String validationSmsUrl = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/validation-sms";
            String resultJsonStr2 = lLianPayClient.sendRequest(validationSmsUrl, JSON.toJSONString(validationSmsParams));
            ValidationSmsResult validationSmsResult = JSON.parseObject(resultJsonStr2, ValidationSmsResult.class);
            System.out.println(validationSmsResult);
        }
    }
}
