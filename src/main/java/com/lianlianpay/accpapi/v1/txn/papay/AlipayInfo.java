package com.lianlianpay.accpapi.v1.txn.papay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AlipayInfo {
    // 订单标题。订单的简单描述，注：支付宝条码支付时为必输。
    private String subject;
    // 订单描述。
    private String body;
    // 卖家ID。如果该值为空，则默认为商户签约账户对应的支付宝用户ID。
    private String seller_id;
    /*
    业务扩展字段。渠道扩展字段JSON串，若渠道为支付宝，则支持的键值对如下：
    sys_service_provider_id
    hb_fq_num
    hb_fq_seller_percent
    industry_reflux_info
    card_type
    支付宝微信同时支持键值：accp_sub_mch_id 子商户号
    微信H5扩展参数：req_domain 来源域名
     */
    private String extend_params;
}
