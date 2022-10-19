package com.lianlianpay.accpapi.v1.txn.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TransferMorepyeePayerInfo {
    private String payer_type;
    private String payer_id;
    /*
    付款方账户类型。付款方类型为商户时需要指定平台商户账户类型。
    USEROWN：用户自有可用账户。
    MCHOWN：平台商户自有可用账户。
     */
    private String payer_accttype;
    /*
    支付密码。非委托代发，付款方为用户时必填。
    通过密码控件加密成密文传输。
     */
    private String password;
    private String random_key;
    /*
    委托代发协议号。账户+返回的的代扣协议号，委托代发时必输。该字段需要RSA公钥加密传输。
    通过用户委托协议签约接口获取
     */
    private String pap_agree_no;
}
