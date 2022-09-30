package com.lianlianpay.accpapi.v1.acctmgr.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyContactsInfo {
    private String contacts_name;
    private String contacts_phone;
    private String contacts_id_type;
    private String contacts_idno;
}
