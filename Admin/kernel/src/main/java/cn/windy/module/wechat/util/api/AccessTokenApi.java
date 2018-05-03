package cn.windy.module.wechat.util.api;

import cn.windy.module.wechat.model.WeChatSetting;
import cn.windy.module.wechat.service.cache.WeChatSettingCache;
import cn.windy.module.wechat.util.HttpUtil;
import cn.windy.module.wechat.util.api.bean.AccessToken;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**

 * access_token是公众号的全局唯一接口调用凭据，不是获取用户信息的access_token

 */
public class AccessTokenApi {

    private static Map<String,AccessToken> map = new HashMap<>();

    public static String getToken(){
        AccessToken accessToken = map.get("access_token");
        System.out.println(accessToken);
        if(accessToken == null || accessToken.getToken() == null || accessToken.isExpired()){
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
            WeChatSetting setting = WeChatSettingCache.getSetting();
            url = String.format(url, setting.getAppId(),setting.getSecret());
            String accessTokenJson = HttpUtil.execute(url,null);
            JSONObject object = (JSONObject) JSON.parse(accessTokenJson);
            accessToken = new AccessToken(object.getString("access_token"),object.getIntValue("expires_in"));
            map.put("access_token",accessToken);
        }
        return accessToken.getToken();
    }

}
