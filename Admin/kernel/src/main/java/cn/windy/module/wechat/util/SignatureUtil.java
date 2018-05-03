package cn.windy.module.wechat.util;

import cn.windy.module.wechat.service.cache.WeChatSettingCache;
import cn.windy.util.encrypt.SHA1;

import java.util.Arrays;

public class SignatureUtil {

    static String token = "";
    static{
        token = WeChatSettingCache.getSetting().getToken();
    }

    /**

     * 验证签名

     *

     * @param signature

     * @param timestamp

     * @param nonce

     * @return

     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] { "vertical", timestamp, nonce };
        // 将token、timestamp、nonce三个参数进行字典序排序

        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }

        String tmpStr = SHA1.encode(content.toString());


        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信

        return tmpStr != null ? tmpStr.equalsIgnoreCase(signature.toUpperCase()) : false;
    }

}
