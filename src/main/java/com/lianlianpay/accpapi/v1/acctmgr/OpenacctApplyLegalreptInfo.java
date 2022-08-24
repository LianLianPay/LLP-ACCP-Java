package com.lianlianpay.accpapi.v1.acctmgr;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyLegalreptInfo {
    private String legalrept_name;
    private String legalrept_phone;
    private String legalrept_idno;
    private String legalrept_idexp;
}
