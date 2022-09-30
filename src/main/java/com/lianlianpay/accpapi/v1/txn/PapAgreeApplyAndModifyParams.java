package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户委托协议申请 请求参数
 */
@Data
@EqualsAndHashCode
public class PapAgreeApplyAndModifyParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private String txn_time;
    private String user_id;
    private String pap_agree_no;
    /*
    交易发起渠道。
    ANDROID
    IOS
    H5
    PC
    目前只支持H5。
     */
    private String flag_chnl;
    private String return_url;
    private String notify_url;
    // 签约信息
    private PapAgreeSignInfo papSignInfo;
}
