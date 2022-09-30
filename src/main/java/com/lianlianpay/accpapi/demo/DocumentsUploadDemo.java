package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.documents.UploadParams;
import com.lianlianpay.accpapi.v1.documents.UploadResult;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传 Demo
 */
public class DocumentsUploadDemo {
    public static void main(String[] args) {
        UploadParams params = new UploadParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id("LLianPayTest-In-User-12345");
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        // 文件类型。支持bmp、png、jpeg、jpg、gif
        params.setFile_type("jpeg");
        params.setContext_type("USER_IMAGE");
        params.setFile_name("照片");
        // 文件内容
        params.setFile_context(getImagBase64());

        // 测试环境URL
        String url = "https://accpfile-ste.lianlianpay-inc.com/v1/documents/upload";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        UploadResult uploadResult = JSON.parseObject(resultJsonStr, UploadResult.class);
        System.out.println(uploadResult);
    }

    /**
     * 读取resource下的一张示例图片，转化成BASE64字符串，不需要加前缀data:image/png;base64
     *
     * @return
     */
    public static String getImagBase64() {
        InputStream inputStream = DocumentsUploadDemo.class.getClassLoader().getResourceAsStream("documents-upload-example.jpeg");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            byte[] temp = new byte[1024];
            int len;
            while ((len = inputStream.read(temp)) != -1) {
                outputStream.write(temp, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return new BASE64Encoder().encode(outputStream.toByteArray());
    }
}
