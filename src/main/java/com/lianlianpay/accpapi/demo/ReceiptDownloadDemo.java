package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.offlinetxn.ReceiptDownloadParams;
import com.lianlianpay.accpapi.v1.offlinetxn.ReceiptDownloadResult;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 电子回单下载 Demo
 */
public class ReceiptDownloadDemo {
    public static void main(String[] args) {
        ReceiptDownloadParams params = new ReceiptDownloadParams();
        params.setTimestamp(LLianPayDateUtils.getTimestamp());
        params.setOid_partner(LLianPayConstant.OidPartner);
        // 电子回单生成接口返回的token
        params.setToken("6a456fbd3c6ffaecccdc3cadba1a3621");
        // 电子回单生成接口返回的电子回单流水号
        params.setReceipt_accp_txno("2022092116412310");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/offlinetxn/receipt-download";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        ReceiptDownloadResult receiptDownloadResult = JSON.parseObject(resultJsonStr, ReceiptDownloadResult.class);
        System.out.println(receiptDownloadResult);
        // 保存对账单到本地
        base64ToFile(receiptDownloadResult.getReceipt_sum_file(), "D:\\Receipts\\");
    }

    /**
     * 原base64压缩文件转文件
     *
     * @param base64 原Base64压缩文件
     * @param path   文件保存路径
     * @throws RuntimeException
     */
    public static void base64ToFile(String base64, String path) throws RuntimeException {
        System.out.println("解压文件地址" + path);
        try {
            byte[] byteBase64 = Base64.getDecoder().decode(base64);
            ByteArrayInputStream byteArray = new ByteArrayInputStream(byteBase64);
            ZipInputStream zipInput = new ZipInputStream(byteArray);
            ZipEntry entry = zipInput.getNextEntry();
            File fout = null;
            File filePath = new File(path);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            while (entry != null && !entry.isDirectory()) {
                System.out.println("文件名称: " + entry.getName());
                fout = new File(filePath, entry.getName());
                if (!fout.exists()) {
                    (new File(fout.getParent())).mkdirs();
                }
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fout));
                int offo = -1;
                byte[] buffer = new byte[1024];
                while ((offo = zipInput.read(buffer)) != -1) {
                    bos.write(buffer, 0, offo);
                }
                bos.close();
                // 获取 下一个文件
                entry = zipInput.getNextEntry();
            }
            zipInput.close();
            byteArray.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解压流出现异常", e);
        }
    }
}
