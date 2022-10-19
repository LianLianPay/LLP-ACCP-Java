package com.lianlianpay.controller;

import com.lianlianpay.service.AccpCashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取账户+相关的controller
 */
@Controller
public class AccpCashierController {
    @Autowired
    private AccpCashierService accpCashierService;

    @RequestMapping("/cashier/go-pay")
    public String goPay(Model model) {
        // 生成账户+收银台gateway_url
        String gatewayUrl = accpCashierService.generateGatewayUrl();
        // 设置参数值，方便前端可以通过这个参数名获取真实的gateway_url
        model.addAttribute("gateway_url", gatewayUrl);
        // 跳转到收银台中间页
        return "accp-cashier";
    }
}
