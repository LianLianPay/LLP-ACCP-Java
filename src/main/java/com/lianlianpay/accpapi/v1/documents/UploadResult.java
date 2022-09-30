package com.lianlianpay.accpapi.v1.documents;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件上传 响应参数
 */
@Data
@EqualsAndHashCode
public class UploadResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String doc_id;
    private String txn_seqno;
}
