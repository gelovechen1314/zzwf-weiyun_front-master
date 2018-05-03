package cn.windy.module.wechat.util.api.bean;

public class Signature {
    /**

     * signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。

     * timestamp 时间戳

     * nonce     随机数

     * echostr   随机字符串

     */
    String signature;
    String timestamp;
    String nonce;
    String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    @Override
    public String toString() {
        return "Signature{" +
                "signature='" + signature + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", echostr='" + echostr + '\'' +
                '}';
    }
}
