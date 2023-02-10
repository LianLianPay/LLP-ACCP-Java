package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.papay.*;

/**
 * 委托代扣 Demo
 */
public class PaymentPapayDemo {
    public static void main(String[] args) {
        PaymentPapayParams params = new PaymentPapayParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_type("GENERAL_CONSUME");
        params.setUser_id("LLianPayTest-In-User-12345");
        params.setClient_ip("127.0.0.1");
        params.setRisk_item("{\"frms_ware_category\":\"4007\",\"goods_name\":\"测试商品\",\"user_info_mercht_userno\":\"" + params.getUser_id() + "\",\"user_info_dt_register\":\"20220823101239\",\"user_info_bind_phone\":\"13308123456\",\"user_info_full_name\":\"连连测试\",\"user_info_id_no\":\"123456789012345678\",\"user_info_identify_state\":\"0\",\"user_info_identify_type\":\"4\",\"user_info_id_type\":\"0\",\"frms_client_chnl\":\" 16\",\"frms_ip_addr\":\"127.0.0.1\",\"user_auth_flag\":\"1\"}");

        PaymentPapayOrderInfo orderInfo = new PaymentPapayOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(1.00);
        orderInfo.setGoods_name("西瓜");
        params.setOrderInfo(orderInfo);

        PaymentPapayPayerInfo payerInfo = new PaymentPapayPayerInfo();
        payerInfo.setPayer_id("LLianPayTest-In-User-12345");
        payerInfo.setPayer_type("USER");
        // 委托代扣协议id
        payerInfo.setContract_id(LLianPayAccpSignature.getInstance().localEncrypt("2022093000265008"));
        params.setPayerInfo(payerInfo);

        PaymentPapayPayMethod payMethods = new PaymentPapayPayMethod();
        payMethods.setMethod("BALANCE");
        payMethods.setAmount(1.00);
        params.setPayMethods(payMethods);

        PaymentPapayPayeeInfo payeeInfo = new PaymentPapayPayeeInfo();
        payeeInfo.setPayee_id(LLianPayConstant.OidPartner);
        payeeInfo.setPayee_type("MERCHANT");
        payeeInfo.setPayee_amount("1.00");
        params.setPayeeInfo(payeeInfo);

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/payment-papay";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        PaymentPapayResult paymentPapayResult = JSON.parseObject(resultJsonStr, PaymentPapayResult.class);
        System.out.println(paymentPapayResult);
    }
}
