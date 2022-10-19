package com.lianlianpay.controller;

import com.lianlianpay.service.PasswordControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取密码控件相关信息的controller
 */
@Controller
public class PasswordControlController {

    @Autowired
    PasswordControlService passwordControlService;

    /**
     * 密码控件-H5非国密最新，调用后端"随机因子获取"接口，获取的响应供前端代码使用
     *
     * @param model
     * @return
     */
    @RequestMapping("/password/h5-non-national")
    public String getH5NonNationalPasswordInfo(Model model) {
        // 调用后端"随机因子获取"接口，获取的响应供前端代码使用，flag_chnl=H5
        String random = passwordControlService.getRandom("H5");
        // 设置参数值，方便前端可以通过这个参数名获取真实的random
        model.addAttribute("randomValue", random);
        // 跳转到H5密码控件页面
        return "h5-non-national-pawword-control";
    }

    /**
     * 密码控件-PCH5最新，调用后端"随机因子获取"接口，获取的响应供前端代码使用
     *
     * @param model
     * @return
     */
    @RequestMapping("/password/pch5")
    public String getPCH5PasswordInfo(Model model) {
        // 调用后端"随机因子获取"接口，获取的响应供前端代码使用，flag_chnl=PCH5
        String random = passwordControlService.getRandom("PCH5");
        // 设置参数值，方便前端可以通过这个参数名获取真实的options
        model.addAttribute("options", random);
        // 跳转到PCH5密码控件页面
        return "pch5-password-control";
    }

    /**
     * 密码控件-H5密码控件（弹框），调用后端"申请密码控件Token"接口，获取的响应供前端代码使用
     *
     * @param model
     * @return
     */
    @RequestMapping("/password/h5-bullet-frame")
    public String getH5BulletFramePasswordInfo(Model model) {
        // 调用后端"申请密码控件Token"接口，获取的响应供前端代码使用
        String h5PasswordInfo = passwordControlService.getPasswordElementToken();
        // 设置参数值，方便前端可以通过这个参数名获取真实的passwordControlArgs
        model.addAttribute("passwordControlArgs", h5PasswordInfo);
        // 跳转到H5密码控件（弹框）页面
        return "h5-bullet-frame-password-control";
    }
}
