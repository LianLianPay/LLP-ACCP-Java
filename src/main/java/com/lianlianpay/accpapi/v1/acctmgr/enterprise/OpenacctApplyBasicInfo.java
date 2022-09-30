package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyBasicInfo {
    private String reg_phone;
    private String reg_phone_evidence;
    private String user_name;
    private String id_type;
    private String id_no;
    private String id_exp;
    private String id_std;
    private String unified_code;
    private String address;
    private String address_pic;
    private String reg_email;
    private String password;
    private String random_key;
}
