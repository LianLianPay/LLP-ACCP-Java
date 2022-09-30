package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.TradeCreateOrderInfo;
import com.lianlianpay.accpapi.v1.txn.TradeCreateParams;
import com.lianlianpay.accpapi.v1.txn.TradeCreatePayeeInfo;
import com.lianlianpay.accpapi.v1.txn.TradeCreateResult;

/**
 * 支付统一创单 Demo
 */
public class TradeCreateDemo {
    public static void main(String[] args) throws Exception {

        // 用户充值
        //userTopup();
        // 普通消费
        generalConsume();
    }

    /**
     * 用户充值
     */
    public static TradeCreateResult userTopup() {
        TradeCreateParams params = new TradeCreateParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        // 普通消费
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

        // 设置商户订单信息
        TradeCreateOrderInfo orderInfo = new TradeCreateOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(100.00);
        orderInfo.setGoods_name("用户充值");
        params.setOrderInfo(orderInfo);

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/tradecreate";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        TradeCreateResult tradeCreateResult = JSON.parseObject(resultJsonStr, TradeCreateResult.class);
        System.out.println(tradeCreateResult);
        return tradeCreateResult;
    }

    /**
     * 普通消费
     */
    public static TradeCreateResult generalConsume() {
        TradeCreateParams params = new TradeCreateParams();
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

        // 设置商户订单信息
        TradeCreateOrderInfo orderInfo = new TradeCreateOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(150.00);
        orderInfo.setGoods_name("西瓜");
        params.setOrderInfo(orderInfo);

        // 设置收款方信息，消费分账场景支持上送多收款方（最多10个），收款总金额必须和订单总金额相等
        TradeCreatePayeeInfo mPayeeInfo = new TradeCreatePayeeInfo();
        mPayeeInfo.setPayee_id(LLianPayConstant.OidPartner);
        mPayeeInfo.setPayee_type("MERCHANT");
        mPayeeInfo.setPayee_amount("50.00");
        mPayeeInfo.setPayee_memo("分账");

        TradeCreatePayeeInfo uPayeeInfo = new TradeCreatePayeeInfo();
        uPayeeInfo.setPayee_id("LLianPayTest-En-User-12345");
        uPayeeInfo.setPayee_type("USER");
        uPayeeInfo.setPayee_amount("100.00");
        uPayeeInfo.setPayee_memo("分账");
        params.setPayeeInfo(new TradeCreatePayeeInfo[]{mPayeeInfo, uPayeeInfo});

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/tradecreate";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        TradeCreateResult tradeCreateResult = JSON.parseObject(resultJsonStr, TradeCreateResult.class);
        System.out.println(tradeCreateResult);
        return tradeCreateResult;
    }

    /**
     * 担保消费
     */
    public static TradeCreateResult securedConsume() {
        TradeCreateParams params = new TradeCreateParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        // 普通消费
        params.setTxn_type("SECURED_CONSUME");
        params.setUser_id("LLianPayTest-In-User-12345");
        /*
        用户类型。默认：注册用户。
        注册用户：REGISTERED
        匿名用户：ANONYMOUS
         */
        params.setUser_type("REGISTERED");
        params.setNotify_url("https://test.lianlianpay/notify");
        params.setReturn_url("https://open.lianlianpay.com?jump=page");

        // 设置商户订单信息
        TradeCreateOrderInfo orderInfo = new TradeCreateOrderInfo();
        orderInfo.setTxn_seqno("LLianPayTest" + timestamp);
        orderInfo.setTxn_time(timestamp);
        orderInfo.setTotal_amount(50.00);
        orderInfo.setGoods_name("西瓜");
        params.setOrderInfo(orderInfo);

        // 担保交易可以先不指定收款方信息

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/tradecreate";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        TradeCreateResult tradeCreateResult = JSON.parseObject(resultJsonStr, TradeCreateResult.class);
        System.out.println(tradeCreateResult);
        return tradeCreateResult;
    }
}
