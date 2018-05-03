package cn.windy.module.wechat.util.api;

import cn.windy.module.wechat.model.WeChatSetting;
import cn.windy.module.wechat.service.cache.WeChatSettingCache;
import cn.windy.module.wechat.util.HttpUtil;
import cn.windy.module.wechat.util.api.bean.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**

 * 获取用户信息，分为两个步骤

 * 1、根据用户的授权code，获取access_token,注意与AccessTokenApi中access_token的区别，二者不同

 * 2、根据access_token获取UserInfo

 */
public class UserInfoApi {

    private static Logger log = LoggerFactory.getLogger(UserInfoApi.class);

    public static UserInfo execute(String code){
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        WeChatSetting setting = WeChatSettingCache.getSetting();
        url = String.format(url,setting.getAppId(),setting.getSecret(),code);

        String result = HttpUtil.execute(url,null);
        JSONObject object = (JSONObject) JSON.parse(result);

        String token = object.getString("access_token");
        String openid = object.getString("openid");

        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid(openid);
        userInfo.setAccessToken(token);

        return userInfo;
    }

    public static UserInfo getUserInfo(String token,String openid){
        //2、获取用户信息

        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
        url = String.format(url,token,openid);
        String result = HttpUtil.execute(url,null);
        log.info("userinfo:{}",result);
        JSONObject object = (JSONObject) JSON.parse(result);
        return new UserInfo(object);
    }

    public static UserInfo getUserInfo2(String openid){
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
        url = String.format(url,AccessTokenApi.getToken(),openid);
        String result = HttpUtil.execute(url,null);
        log.info("userinfo:{}",result);
        JSONObject object = (JSONObject) JSON.parse(result);
        return new UserInfo(object);
    }

}
