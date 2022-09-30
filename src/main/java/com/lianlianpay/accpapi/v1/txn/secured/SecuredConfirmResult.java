package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 担保交易确认 响应参数
 */
@Data
@EqualsAndHashCode
public class SecuredConfirmResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private Double total_amount;
    private String accp_txno;
    private String accp_confirm_txno;
}
