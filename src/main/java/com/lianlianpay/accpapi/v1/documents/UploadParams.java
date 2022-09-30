package com.lianlianpay.accpapi.v1.documents;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件上传 请求参数
 */
@Data
@EqualsAndHashCode
public class UploadParams {
    private String timestamp;
    private String oid_partner;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    // 文件类型。支持bmp、png、jpeg、jpg、gif
    private String file_type;
    private String context_type;
    /*
    文件名称。内容类型为SUPPLEMENT_CSV时必填
    格式为SUPPLEMENT_CSV_商户号_对账日期.csv注：文件名请使用大写字母
     */
    private String file_name;
    /*
    文件内容。文件流通过Base64编码后传输，字符编码UTF-8；最大6M。
    Base64编码后的字符串需去掉前缀，前缀示例：data:image/png;base64
     */
    private String file_context;
}
