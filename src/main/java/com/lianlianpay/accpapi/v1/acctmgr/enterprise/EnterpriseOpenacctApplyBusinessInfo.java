package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class EnterpriseOpenacctApplyBusinessInfo {
    private String scale;
    private String industry_code;
    private String registered_capital;
    private String business_scope;
    private String open_permit;
}
