package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyUboInfos {
    private String ubo_name;
    private String ubo_name_en;
    private String ubo_phone;
    private String id_type;
    private String id_no;
    private String id_emblem;
    private String id_portrait;
    private String unified_code;
    private String id_exp;
    private String id_issue;
    private String address;
    private String ubo_evidence;
    private String ubo_type;
}
