package com.lianlianpay.controller;

import com.lianlianpay.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
public class NotifyController {
    @Autowired
    NotifyService notifyService;

    @RequestMapping(method = RequestMethod.POST, value = "/notify")
    public String llianPayMessageNotify(HttpServletRequest request) {
        // 从请求头中获取签名值
        String signature = request.getHeader("Signature-Data");
        BufferedReader reader = null;
        try {
            // 从请求体中获取源串
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            log.info("[接收来自连连下发的异步通知] 签名值为：" + signature);
            log.info("[接收来自连连下发的异步通知] 签名源串为：" + stringBuilder.toString());

            // 进行验签
            if (notifyService.checkSign(stringBuilder.toString(), signature)) {
                // 验签通过，处理系统业务逻辑
                log.info("验签通过！！！");

                // 返回Success，响应本次异步通知已经成功
                return "Success";
            } else {
                // 验签失败，进行预警。
                log.error("验签失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        // 没有其他意义，异步通知响应连连这边只认"Success"，返回非"Success"，连连会进行重发
        return "error";
    }
}
