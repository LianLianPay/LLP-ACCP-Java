package com.lianlianpay.service.impl;

import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.service.NotifyService;
import org.springframework.stereotype.Service;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Override
    public boolean checkSign(String souceStr, String signature) {
        return LLianPayAccpSignature.getInstance().checkSign(souceStr, signature);
    }
}
