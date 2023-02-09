package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 担保确认撤销 响应参数
 */
@Data
@EqualsAndHashCode
public class CancelSecuredPaymentResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String accp_txno;
    private String txn_seqno;
    private Double total_amount;
    // 收款方信息
    private List<CancelSecuredPaymentPayeeInfo> payee_info;
}
