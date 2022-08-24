package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IndividualOpenacctApplyBasicInfo {
    private String reg_phone;
    private String user_name;
    private String id_type;
    private String id_no;
    private String id_exp;
    private String id_std;
    private String id_authority;
    private String area_code;
    private String address;
    private String occupation;
    private String id_emblem;
    private String id_portrait;
}
