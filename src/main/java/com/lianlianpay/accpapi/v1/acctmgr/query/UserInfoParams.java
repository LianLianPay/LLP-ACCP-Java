package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息查询 请求参数
 */
@Data
@EqualsAndHashCode
public class UserInfoParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
}
