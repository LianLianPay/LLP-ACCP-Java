package com.lianlianpay.accpapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.accpapi.client.LLianPayClient;
import com.lianlianpay.accpapi.config.LLianPayConstant;
import com.lianlianpay.accpapi.security.LLianPayAccpSignature;
import com.lianlianpay.accpapi.utils.LLianPayDateUtils;
import com.lianlianpay.accpapi.v1.acctmgr.individual.*;
import com.lianlianpay.accpapi.v1.acctmgr.regphone.VerifyCodeApplyParams;
import com.lianlianpay.accpapi.v1.acctmgr.regphone.VerifyCodeResult;
import com.lianlianpay.accpapi.v1.acctmgr.regphone.VerifyCodeVerifyParams;

/**
 * 个人用户API开户流程 Demo
 */
public class IndividualOpenacctDemo {
    public static void main(String[] args) {

        String userId = "LLianPayTest-Api-User-12345";
        LLianPayClient lLianPayClient = new LLianPayClient();
        // 绑定手机验证码申请
        VerifyCodeResult applyResult = phoneVerifyCodeApply(lLianPayClient, userId);
        if (!"0000".equals(applyResult.getRet_code())) {
            System.out.println("绑定手机号验证申请失败，请检查！");
            return;
        }

        // 触发绑定手机验证码申请时，会下发短信验证码
        // 用Debug模式，断点打到这里，Debug的时候把verifyCode设置成手机收到的真实验证码
        String verifyCode = "";
        // 绑定手机验证码验证
        VerifyCodeResult verifyResult = phoneVerifyCodeVerify(lLianPayClient, userId, verifyCode);
        if (!"0000".equals(verifyResult.getRet_code())) {
            System.out.println("绑定手机号验证验证失败，请检查！");
            return;
        }

        // 个人开户申请
        OpenacctApplyResult openacctApplyResult = openacctApply(lLianPayClient, userId);

        // 随机密码因子获取接口
        // 测试环境没有接密码控件的话，可以用连连公钥进行加密调试接口
        String password = "qwerty";
        String encryptStr = LLianPayAccpSignature.getInstance().localEncrypt(password);
        // 个人开户验证
        // 用Debug模式，断点打到这里，Debug的时候把verifyCode设置成手机收到的真实验证码
        String openacctVerifyCode = "";
        openacctVerify(lLianPayClient, openacctApplyResult, openacctVerifyCode, encryptStr);
    }

    /**
     * 绑定手机验证码申请
     *
     * @param lLianPayClient
     * @param userId
     * @return
     */
    public static VerifyCodeResult phoneVerifyCodeApply(LLianPayClient lLianPayClient, String userId) {
        VerifyCodeApplyParams params = new VerifyCodeApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id(userId);
        // 设置手机号
        params.setReg_phone("");

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/regphone-verifycode-apply";
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        VerifyCodeResult verifyCodeResult = JSON.parseObject(resultJsonStr, VerifyCodeResult.class);
        System.out.println(verifyCodeResult);
        return verifyCodeResult;
    }

    /**
     * 绑定手机验证码验证
     *
     * @param lianPayClient
     * @param userId
     * @param verifyCode
     * @return
     */
    public static VerifyCodeResult phoneVerifyCodeVerify(LLianPayClient lianPayClient, String userId, String verifyCode) {
        VerifyCodeVerifyParams params = new VerifyCodeVerifyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id(userId);
        // 设置手机号
        params.setReg_phone("");
        params.setVerify_code(verifyCode);

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/regphone-verifycode-verify";
        String resultJsonStr = lianPayClient.sendRequest(url, JSON.toJSONString(params));
        VerifyCodeResult verifyCodeResult = JSON.parseObject(resultJsonStr, VerifyCodeResult.class);
        System.out.println(verifyCodeResult);
        return verifyCodeResult;
    }

    /**
     * 个人开户申请
     *
     * @param lianPayClient
     * @param userId
     * @return
     */
    public static OpenacctApplyResult openacctApply(LLianPayClient lianPayClient, String userId) {
        OpenacctApplyParams params = new OpenacctApplyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id(userId);
        params.setTxn_seqno("LLianPayTest" + timestamp);
        params.setTxn_time(timestamp);
        params.setNotify_url("https://test.lianlianpay/notify");

        // 设置开户基本信息
        OpenacctApplyBasicInfo basicInfo = new OpenacctApplyBasicInfo();
        // 设置手机号
        basicInfo.setReg_phone("");
        // 设置用户名称，企业用户传企业名称，个体工商户传营业执照的名称，个人用户传姓名（正式环境会进行审核的）
        basicInfo.setUser_name("");
        basicInfo.setId_type("ID_CARD");
        // 设置证件号
        basicInfo.setId_no("");
        // 设置证件有效期
        basicInfo.setId_exp("99991231");
        // 设置地址
        basicInfo.setAddress("");
        // 设置职业
        basicInfo.setOccupation("01");
        params.setBasicInfo(basicInfo);

        // 开户账户申请信息
        OpenacctApplyAccountInfo accountInfo = new OpenacctApplyAccountInfo();
        // 个人用户建议设置成个人支付账户类型
        accountInfo.setAccount_type("PERSONAL_PAYMENT_ACCOUNT");
        accountInfo.setAccount_need_level("V3");
        params.setAccountInfo(accountInfo);

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/openacct-apply-individual";
        String resultJsonStr = lianPayClient.sendRequest(url, JSON.toJSONString(params));
        OpenacctApplyResult openacctApplyResult = JSON.parseObject(resultJsonStr, OpenacctApplyResult.class);
        System.out.println(openacctApplyResult);
        return openacctApplyResult;
    }

    /**
     * 个人开户验证
     *
     * @param lianPayClient
     * @param openacctApplyResult
     * @param verifyCode
     * @param password
     */
    public static void openacctVerify(LLianPayClient lianPayClient, OpenacctApplyResult openacctApplyResult, String verifyCode, String password) {
        OpenacctVerifyParams params = new OpenacctVerifyParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setTimestamp(timestamp);
        params.setOid_partner(LLianPayConstant.OidPartner);
        params.setUser_id(openacctApplyResult.getUser_id());
        params.setTxn_seqno(openacctApplyResult.getTxn_seqno());
        params.setToken(openacctApplyResult.getToken());
        // 银行卡短信验证码，如果个人开户申请时，没有输入开户绑卡信息，则不需要输入验证码。
        //params.setVerify_code(verifyCode);
        params.setPassword(password);

        // 测试环境URL
        String url = "https://accpapi-ste.lianlianpay-inc.com/v1/acctmgr/openacct-verify-individual";
        String resultJsonStr = lianPayClient.sendRequest(url, JSON.toJSONString(params));
        OpenacctVerifyResult openacctVerifyResult = JSON.parseObject(resultJsonStr, OpenacctVerifyResult.class);
        System.out.println(openacctVerifyResult);
    }
}
