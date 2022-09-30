package com.lianlianpay.accpapi.v1.offlinetxn;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 电子回单下载 请求参数
 */
@Data
@EqualsAndHashCode
public class ReceiptDownloadParams {
    private String timestamp;
    private String oid_partner;
    // 授权令牌，有效期为120分钟。
    private String token;
    // 电子回单流水号。
    private String receipt_accp_txno;
}
