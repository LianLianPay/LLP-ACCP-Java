package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IndividualOpenacctApplyAccountInfo {
    private String account_type;
    private String account_need_level;
}
