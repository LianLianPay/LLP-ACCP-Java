package com.lianlianpay.accpapi.v1.acctmgr.virtualno;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 虚拟卡申请 请求参数
 */
@Data
@EqualsAndHashCode
public class VirtualNoApplyParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private String txn_time;
    // 虚拟卡参数
    private VirtualInfo virtualInfo;
}
