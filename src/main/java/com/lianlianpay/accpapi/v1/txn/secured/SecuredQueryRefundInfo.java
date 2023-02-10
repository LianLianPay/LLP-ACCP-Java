package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredQueryRefundInfo {
    private String accp_txno;
    private String refund_seqno;
}
