package com.lianlianpay.accpapi.v1.txn.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TransferMorepyeePayeeInfo {
    private String payee_type;
    private String payee_id;
    /*
    收款方账户类型。收款方为平台商户时必传。
    用户账户：USEROWN
    平台商户自有资金账户：MCHOWN
    平台商户优惠券账户：MCHCOUPON
    平台商户手续费账户：MCHFEE
     */
    private String payee_accttype;
    // 收款金额。单位：元，精确到小数点后两位
    private String payee_amount;
}
