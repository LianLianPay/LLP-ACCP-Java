package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecuredQueryPayInfo {
    private String accp_txno;
    private String txn_seqno;
}
