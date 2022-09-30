package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyBasicAcctInfo {
    private String basicacct_bankcode;
    private String basicacct_no;
}
