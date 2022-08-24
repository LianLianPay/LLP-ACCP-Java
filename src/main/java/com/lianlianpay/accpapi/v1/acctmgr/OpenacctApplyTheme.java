package com.lianlianpay.accpapi.v1.acctmgr;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OpenacctApplyTheme {
    // 基础色。默认值为#1976D2 wap端有效产品类型。
    private String primary;
    // 间色。默认值为#424242 wap端有效。
    private String secondary;
    // 强调色。默认值为#82B1FF wap端有效。
    private String accent;
    // 错误色。默认值为#FF5252 wap端有效。
    private String error;
    // 信息色。默认值为#2196F3 wap端有效。
    private String info;
    // 成功色。默认值为#4CAF50 wap端有效。
    private String success;
    // 警告色。默认值为#FFC107 wap端有效。
    private String warning;
}
