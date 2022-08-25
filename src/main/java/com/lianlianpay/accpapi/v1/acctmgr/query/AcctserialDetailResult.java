package com.lianlianpay.accpapi.v1.acctmgr.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 资金流水详情查询 响应参数
 */
@Data
@EqualsAndHashCode
public class AcctserialDetailResult {
    private String ret_code;
    private String ret_msg;
    private String oid_partner;
    private String date_acct;
    private String oid_acctno;
    private String jno_acct;
    private String txn_seqno;
    private String accp_txnno;
    /*
    交易类型。
    用户充值：USER_TOPUP
    商户充值：MCH_TOPUP
    普通消费：GENERAL_CONSUME
    担保消费：SECURED_CONSUME
    手续费收取：SERVICE_FEE
    内部代发：INNER_FUND_EXCHANGE
    外部代发：OUTER_FUND_EXCHANGE
    账户提现：ACCT_CASH_OUT
    担保确认：SECURED_CONFIRM
    手续费应收应付核销：CAPITAL_CANCEL
    定向内部代发：INNER_DIRECT_EXCHANGE
     */
    private String txn_type;
    private String product_code;
    private String other_acct;
    private String other_acct_name;
    private String txn_time;
    private String flag_dc;
    private String amt;
    private String amt_bal;
    private String memo;
    private String jno_cli;
}
