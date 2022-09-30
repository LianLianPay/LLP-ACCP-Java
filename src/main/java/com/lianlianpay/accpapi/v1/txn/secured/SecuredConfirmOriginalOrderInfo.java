package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class SecuredConfirmOriginalOrderInfo {
    private String txn_seqno;
    private Double total_amount;
}
