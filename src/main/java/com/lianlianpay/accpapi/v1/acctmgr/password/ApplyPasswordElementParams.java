package com.lianlianpay.accpapi.v1.acctmgr.password;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 申请密码控件Token 请求参数
 */
@Data
@EqualsAndHashCode
public class ApplyPasswordElementParams {
    private String timestamp;
    private String oid_partner;
    // 商户名称，余额支付场景必填
    private String partner_name;
    // 用户在商户系统中的唯一标识，修改密码场景必填
    private String user_id;
    private String txn_seqno;
    // 交易金额，单位：元，精确到小数点后两位，例如:1.00，支付和提现场景必填
    private Double amount;
    /*
    密码使用场景：
    设置密码：setting_password
    修改密码：change_password
    换绑卡：bind_card_password
    提现密码：cashout_password
    支付密码：pay_password
     */
    private String password_scene;
    private String encrypt_algorithm;
    private String flag_chnl;
    // 收款人姓名，提现场景必填。
    private String pyee_name;
}
