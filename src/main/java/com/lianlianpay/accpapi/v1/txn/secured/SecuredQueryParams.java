package com.lianlianpay.accpapi.v1.txn.secured;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 担保交易信息查询 请求参数
 */
@Data
@EqualsAndHashCode
public class SecuredQueryParams {
    private String timestamp;
    private String oid_partner;
    private String txn_seqno;
    private String accp_txno;
}
