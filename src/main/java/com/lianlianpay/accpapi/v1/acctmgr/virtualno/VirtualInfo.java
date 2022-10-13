package com.lianlianpay.accpapi.v1.acctmgr.virtualno;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class VirtualInfo {
    /*
    所属客户类型。
    用户：USER
    平台商户：MERCHANT
     */
    private String cust_type;
    private String user_id;
    // 申请虚拟卡的客户姓名。会尝试检查通过虚拟卡转账的他行卡户名是否一致。
    private String apply_username;
    // 申请虚拟卡的请求方ID，若为消费类虚拟卡，则必填。
    private String apply_userid;
    /*
    申请虚拟卡场景。消费：consume
    现金上缴：deposit_cash
    费用上缴：deposit_fee
    其他：other
    （payee_id+applay_userid+apply_sence只能一张卡）
     */
    private String apply_sence;
    /*
    虚拟卡业务类型。
    消费业务：OFFLINE_CONSUME
     */
    private String bussiness_type;
    /*
    虚拟卡入账通知URL
    虚拟卡每收到一笔资金时的通知，下附通知样例。
     */
    private String bboc_notify;
}
