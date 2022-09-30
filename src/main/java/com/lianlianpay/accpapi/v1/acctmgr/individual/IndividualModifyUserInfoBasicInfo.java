package com.lianlianpay.accpapi.v1.acctmgr.individual;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IndividualModifyUserInfoBasicInfo {
    private String id_exp;
    private String id_std;
    private String id_emblem;
    private String id_portrait;
    private String id_authority;
    private String address;
    private String area_code;
    private String occupation;
}
