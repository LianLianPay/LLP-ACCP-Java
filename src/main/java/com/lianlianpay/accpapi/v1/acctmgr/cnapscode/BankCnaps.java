package com.lianlianpay.accpapi.v1.acctmgr.cnapscode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class BankCnaps {
    // 大额行号
    private String cnaps_code;
    // 开户支行名称全称
    private String brabank_name;
}
