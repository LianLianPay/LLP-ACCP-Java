package com.lianlianpay.accpapi.v1.txn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PapAgreeSignInfo {
    // 授权开始时间。授权生效日期：yyyyMMdd
    private String sign_start_time;
    // 授权结束时间。授权结束日期：yyyyMMdd
    private String sign_invalid_time;
    // 单笔限额。委托代扣单笔最大交易额度，单位为元。
    private Double single_limit;
    // 单日限额。委托代扣每日最大交易额度，单位为元。
    private Double daily_limit;
    // 单月限额。委托代扣每月最大交易额度，单位为元。
    private Double monthly_limit;
    /*
    免密协议类型。
    WITH_HOLD：免密代扣
    WITH_WITHDRAW：免密提现
    注：若不填写，则默认为免密代扣。
     */
    private String agreement_type;
}
