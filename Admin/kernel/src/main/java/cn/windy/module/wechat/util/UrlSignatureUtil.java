package cn.windy.module.wechat.util;

import cn.windy.module.wechat.util.api.JsapiTicketApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UrlSignatureUtil{

    private static Logger log = LoggerFactory.getLogger(UrlSignatureUtil.class);

    public static Map<String,String> signature(String url) {
        Map<String,String> param = new HashMap<>();
        String signature;
        param.clear();
        StringBuffer result = new StringBuffer("jsapi_ticket=");
        String ticket = JsapiTicketApi.execute();
        param.put("ticket",ticket);
        result.append(ticket);

        result.append("&noncestr=");
        String noncestr = create_nonce_str();
        param.put("noncestr",noncestr);
        result.append(noncestr);

        result.append("&timestamp=");
        String timestamp = create_timestamp();
        param.put("timestamp",timestamp);
        result.append(timestamp);

        result.append("&url=");
        result.append(url);

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(result.toString().getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
            param.put("signature",signature);
        } catch (NoSuchAlgorithmException|UnsupportedEncodingException e) {
            log.error("数据加密失败:",e);
        }

        return param;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

}
