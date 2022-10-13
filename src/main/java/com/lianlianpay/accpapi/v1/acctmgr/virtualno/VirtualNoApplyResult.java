package com.lianlianpay.accpapi.v1.acctmgr.virtualno;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 虚拟卡申请 请求参数
 */
@Data
@EqualsAndHashCode
public class VirtualNoApplyResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    // 虚拟卡卡号，转账支付关联的虚拟卡。
    private String virtualno;
    // 申请人姓名。申请虚拟卡的客户姓名。
    private String apply_username;
    // 申请人ID
    private String apply_userid;
    /*
    申请用途。
    消费：consume
    现金上缴：deposit_cash
    费用上缴：deposit_fee
    其他：other
     */
    private String apply_sence;
    /*
    虚拟卡业务类型。
    消费业务：OFFLINE_CONSUME
     */
    private String bussiness_type;
    // 资金挂账通知地址
    private String bboc_notify;
}
