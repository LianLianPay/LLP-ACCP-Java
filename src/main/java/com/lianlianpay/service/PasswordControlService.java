package com.lianlianpay.service;

public interface PasswordControlService {
    String getRandom(String flagChnl);

    String getPasswordElementToken();
}
