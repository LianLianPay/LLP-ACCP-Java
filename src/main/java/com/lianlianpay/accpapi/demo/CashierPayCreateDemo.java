package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.cashier.*;

/**
 * 账户+收银台 Demo
 */
public class CashierPayCreateDemo {
    public static void main(String[] args) {
        // 普通消费
        generalConsume();

        // 用户充值
        //userTopup();
    }

    /**
     * 用户充值
     */
    public static void userTopup() {
        CashierPayCreateParams params = new CashierPayCreateParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        // 用户充值
        params.setTxn_type("USER_TOPUP");
        params.setUser_id("LLianPayTest-In-User-12345");
        /*
        用户类型。默认：注册用户。
        注册用户：REGISTERED
        匿名用户：ANONYMOUS
         */
        params.setUser_type("REGISTERED");
        params.setNotify_url("https://test.lianlianpay/notify");
        params.setReturn_url("https://open.lianlianpay.com?jump=page");
        // 交易发起渠道设置
        params.setFlag_chnl("H5");
        // 测试风控参数
        params.setRisk_item("{\"frms_ware_category\":\"4007\",\"goods_name\":\"用户充值\",\"user_info_mercht_userno\":\"LLianPayTest-In-User-12345\",\"user_info_dt_register\":\"20220823101239\",\"user_info_bind_phone\":\"13208123456\",\"user_info_full_name\":\"连连测试\",\"user_info_id_no\":\"\",\"user_info_identify_state\":\"0\",\"user_info_identify_type\":\"4\",\"user_info_id_type\":\"0\",\"frms_client_chnl\":\" H5\",\"frms_ip_addr\":\"127.0.0.1\",\"user_auth_flag\":\"1\"}");

        // 设置商户订单信息
        CashierPayCreateOrderInfo orderInfo = new CashierPayCreateOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(100.00);
        orderInfo.setGoods_name("用户充值");
        params.setOrderInfo(orderInfo);

        // 设置付款方信息
        CashierPayCreatePayerInfo payerInfo = new CashierPayCreatePayerInfo();
        payerInfo.setPayer_id("LLianPayTest-In-User-12345");
        payerInfo.setPayer_type("USER");
        params.setPayerInfo(payerInfo);

        // 测试环境URL
        String url = "https://accpgw-ste.lianlianpay-inc.com/v1/cashier/paycreate";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        CashierPayCreateResult cashierPayCreateResult = JSON.parseObject(resultJsonStr, CashierPayCreateResult.class);
        System.out.println(cashierPayCreateResult);
    }

    /**
     * 普通消费
     */
    public static void generalConsume() {
        CashierPayCreateParams params = new CashierPayCreateParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        // 普通消费
        params.setTxn_type("GENERAL_CONSUME");
        params.setUser_id("LLianPayTest-In-User-12345");
        /*
        用户类型。默认：注册用户。
        注册用户：REGISTERED
        匿名用户：ANONYMOUS
         */
        params.setUser_type("REGISTERED");
        params.setNotify_url("https://test.lianlianpay/notify");
        params.setReturn_url("https://open.lianlianpay.com?jump=page");
        // 交易发起渠道设置
        params.setFlag_chnl("H5");
        // 测试风控参数
        params.setRisk_item("{\"frms_ware_category\":\"4007\",\"goods_name\":\"西瓜\",\"user_info_mercht_userno\":\"LLianPayTest-In-User-12345\",\"user_info_dt_register\":\"20220823101239\",\"user_info_bind_phone\":\"13208123456\",\"user_info_full_name\":\"连连测试\",\"user_info_id_no\":\"\",\"user_info_identify_state\":\"0\",\"user_info_identify_type\":\"4\",\"user_info_id_type\":\"0\",\"frms_client_chnl\":\" H5\",\"frms_ip_addr\":\"127.0.0.1\",\"user_auth_flag\":\"1\"}");

        // 设置商户订单信息
        CashierPayCreateOrderInfo orderInfo = new CashierPayCreateOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(1.00);
        orderInfo.setGoods_name("西瓜");
        params.setOrderInfo(orderInfo);

        // 设置收款方信息，消费分账场景支持上送多收款方（最多10个），收款总金额必须和订单总金额相等
        CashierPayCreatePayeeInfo mPayeeInfo = new CashierPayCreatePayeeInfo();
        mPayeeInfo.setPayee_id(LLianPayConstant.OidPartner);
        mPayeeInfo.setPayee_type("MERCHANT");
        mPayeeInfo.setPayee_amount("0.5");
        mPayeeInfo.setPayee_memo("分账");

        CashierPayCreatePayeeInfo uPayeeInfo = new CashierPayCreatePayeeInfo();
        uPayeeInfo.setPayee_id("LLianPayTest-En-User-12345");
        uPayeeInfo.setPayee_type("USER");
        uPayeeInfo.setPayee_amount("0.5");
        uPayeeInfo.setPayee_memo("分账");
        params.setPayeeInfo(new CashierPayCreatePayeeInfo[]{mPayeeInfo, uPayeeInfo});

        // 设置付款方信息
        CashierPayCreatePayerInfo payerInfo = new CashierPayCreatePayerInfo();
        payerInfo.setPayer_id("LLianPayTest-In-User-12345");
        payerInfo.setPayer_type("USER");
        params.setPayerInfo(payerInfo);

        // 测试环境URL
        String url = "https://accpgw-ste.lianlianpay-inc.com/v1/cashier/paycreate";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        CashierPayCreateResult cashierPayCreateResult = JSON.parseObject(resultJsonStr, CashierPayCreateResult.class);
        System.out.println(cashierPayCreateResult);
    }
}
