package com.lianlianpay.accpapi.v1.txn.papay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WechatInfo {
    // 商品描述，商品或支付单简要描述。注：微信付款码支付时为必输。
    private String body;
    // 商品详情。
    private String detail;
}
