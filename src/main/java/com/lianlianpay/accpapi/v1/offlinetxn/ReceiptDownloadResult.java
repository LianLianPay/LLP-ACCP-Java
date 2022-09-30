package com.lianlianpay.accpapi.v1.offlinetxn;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 电子回单下载 响应参数
 */
@Data
@EqualsAndHashCode
public class ReceiptDownloadResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String trade_txn_seqno;
    private String trade_accp_txno;
    private Double total_amount;
    private String receipt_accp_txno;
    /*
    电子回单生成状态。
    SUCCESS:生成成功
    HANDING:生成中
    UNSUPPORT:不支持电子回单
     */
    private String receipt_status;
    // 电子回单生集合文件。所有加密后文件做zip压缩，压缩文件做Base64编码后传输，字符编码UTF-8。
    private String receipt_sum_file;
    // 电子回单信息集合
    private List<ReceiptInfo> receiptInfo;
}
