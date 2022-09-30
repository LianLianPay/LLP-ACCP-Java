package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyLegalreptInfo {
    private String legalrept_name;
    private String legalrept_phone;
    private String legalrept_id_type;
    private String legalrept_idno;
    private String id_emblem;
    private String id_portrait;
    private String legalrept_idexp;
    private String legalrept_std;
}
