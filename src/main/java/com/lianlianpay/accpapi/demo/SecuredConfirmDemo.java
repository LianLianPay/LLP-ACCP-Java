package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.txn.TradeCreateResult;
import com.lianlianpay.accpapi.v1.txn.secured.*;

/**
 * 担保确认 Demo
 */
public class SecuredConfirmDemo {
    public static void main(String[] args) {
        TradeCreateResult tradeCreateResult = PaymentBalanceDemo.securedConsumePay();
        SecuredConfirmParams params = new SecuredConfirmParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id(tradeCreateResult.getUser_id());
        /*
        确认方式。
        ALL：全订单金额一次性确认（创单时指定了收款方）
        PART：订单金额部分多次确认
         */
        params.setConfirm_mode("PART");

        // 原商户订单信息
        SecuredConfirmOriginalOrderInfo originalOrderInfo = new SecuredConfirmOriginalOrderInfo();
        // 原商户订单交易流水号
        originalOrderInfo.setTxn_seqno(tradeCreateResult.getTxn_seqno());
        // 原商户订单总金额
        originalOrderInfo.setTotal_amount(tradeCreateResult.getTotal_amount());
        params.setOriginalOrderInfo(originalOrderInfo);

        // 确认订单信息
        SecuredConfirmOrderInfo orderInfo = new SecuredConfirmOrderInfo();
        // 确认订单号
        orderInfo.setConfirm_seqno("LLianPayTest" + timestamp);
        orderInfo.setConfirm_time(timestamp);
        orderInfo.setConfirm_amount(tradeCreateResult.getTotal_amount());
        params.setConfirmOrderInfo(orderInfo);

        SecuredConfirmPayeeInfo payeeInfo = new SecuredConfirmPayeeInfo();
        payeeInfo.setPayee_id(LLianPayConstant.OidPartner);
        payeeInfo.setPayee_type("MERCHANT");
        payeeInfo.setPayee_amount("10.00");

        SecuredConfirmPayeeInfo payeeInfo1 = new SecuredConfirmPayeeInfo();
        payeeInfo1.setPayee_id("LLianPayTest-En-User-12345");
        payeeInfo1.setPayee_type("USER");
        payeeInfo1.setPayee_amount("20.00");

        SecuredConfirmPayeeInfo payeeInfo2 = new SecuredConfirmPayeeInfo();
        payeeInfo2.setPayee_id("ll627544175777419265");
        payeeInfo2.setPayee_type("USER");
        payeeInfo2.setPayee_amount("20.00");
        params.setPayeeInfo(new SecuredConfirmPayeeInfo[]{payeeInfo, payeeInfo1, payeeInfo2});

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/txn/secured-confirm";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        SecuredConfirmResult securedConfirmResult = JSON.parseObject(resultJsonStr, SecuredConfirmResult.class);
        System.out.println(securedConfirmResult);
    }
}
