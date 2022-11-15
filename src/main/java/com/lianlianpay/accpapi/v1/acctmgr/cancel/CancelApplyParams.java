package com.lianlianpay.accpapi.v1.acctmgr.cancel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 销户申请 请求参数
 */
@Data
@EqualsAndHashCode
public class CancelApplyParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String notify_url;
    // 用户名称。企业用户传企业名称，个体工商户传营业执照的名称（营业执照上名称是****或者无的，传经营者姓名），个人用户传姓名。
    private String user_name;
    /*
    证件类型。
    身份证：ID_CARD
    统一社会信用代码证：UNIFIED_SOCIAL_CREDIT_CODE。
     */
    private String id_type;
    // 证件号码。 对应id_type的相关证件号码。
    private String id_no;
    // 绑定手机号。用户开户注册绑定手机号。
    private String reg_phone;
    private String password;
    private String random_key;
}
