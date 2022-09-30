package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.offlinetxn.ReceiptProduceParams;
import com.lianlianpay.accpapi.v1.offlinetxn.ReceiptProduceResult;

/**
 * 电子回单生成 Demo
 */
public class ReceiptProduceDemo {
    public static void main(String[] args) {
        ReceiptProduceParams params = new ReceiptProduceParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setTrade_accp_txno("2022092116412310");
        /*
        原交易订单类型。
        PAYBILL:支付（包含充值，消费，内部代发，担保消费，担保确认）
        CASHOUT:外部代发，提现
        REFUND:退款
         */
        params.setTrade_bill_type("PAYBILL");
        params.setTotal_amount(202.00);

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/offlinetxn/receipt-produce";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        ReceiptProduceResult receiptProduceResult = JSON.parseObject(resultJsonStr, ReceiptProduceResult.class);
        System.out.println(receiptProduceResult);
    }
}
