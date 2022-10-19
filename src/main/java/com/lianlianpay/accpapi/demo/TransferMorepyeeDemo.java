package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.transfer.*;

import java.util.Arrays;

/**
 * 内部代发申请 Demo
 */
public class TransferMorepyeeDemo {
    public static void main(String[] args) {
        TransferMorepyeeParams params = new TransferMorepyeeParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        // 测试风控参数
        params.setRisk_item("{\"frms_ware_category\":\"4007\",\"goods_name\":\"西瓜\",\"user_info_mercht_userno\":\"LLianPayTest-In-User-12345\",\"user_info_dt_register\":\"20220823101239\",\"user_info_bind_phone\":\"13208123456\",\"user_info_full_name\":\"连连测试\",\"user_info_id_no\":\"\",\"user_info_identify_state\":\"0\",\"user_info_identify_type\":\"4\",\"user_info_id_type\":\"0\",\"frms_client_chnl\":\" H5\",\"frms_ip_addr\":\"127.0.0.1\",\"user_auth_flag\":\"1\"}");

        // 商户订单信息
        TransferMorepyeeOrderInfo orderInfo = new TransferMorepyeeOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(300.00);
        /*
        代发交易用途。
        服务费
        信息费
        修理费
        佣金支付
        贷款
        其他
         */
        orderInfo.setTxn_purpose("其他");
        params.setOrderInfo(orderInfo);

        // 付款方信息
        TransferMorepyeePayerInfo payerInfo = new TransferMorepyeePayerInfo();
        /*
        付款方类型。
        用户：USER
        平台商户：MERCHANT
         */
        payerInfo.setPayer_type("USER");
        /*
        付款方标识。
        付款方为用户时设置user_id 。
        付款方为商户时设置平台商户号。
         */
        payerInfo.setPayer_id("20220930162843205648385");
        /*
        委托代发协议号。账户+返回的的代扣协议号，委托代发时必输。该字段需要RSA公钥加密传输。
        通过用户委托协议签约接口获取
         */
        payerInfo.setPap_agree_no(LLianPayAccpSignature.getInstance().localEncrypt("2022101800274008"));
        params.setPayerInfo(payerInfo);

        // 收款方信息
        TransferMorepyeePayeeInfo payeeInfo = new TransferMorepyeePayeeInfo();
        /*
        收款方类型。
        用户：USER
        平台商户：MERCHANT
         */
        payeeInfo.setPayee_type("USER");
        // 收款方标识，收款方为用户时，为用户user_id，收款方为平台商户时，取平台商户号
        payeeInfo.setPayee_id("LLianPayTest-En-User-12345");
        payeeInfo.setPayee_amount("300.00");
        params.setPayeeInfo(Arrays.asList(payeeInfo));

        // 测试环境请求地址
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/transfer-morepyee";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        TransferMorepyeeResult transferMorepyeeResult = JSON.parseObject(resultJsonStr, TransferMorepyeeResult.class);
        System.out.println(transferMorepyeeResult);
    }
}
