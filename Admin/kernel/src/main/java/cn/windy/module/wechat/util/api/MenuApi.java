package cn.windy.module.wechat.util.api;

import cn.windy.module.wechat.util.HttpUtil;

public class MenuApi {

    public static String execute(String menuJson){
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
        url = String.format(url,AccessTokenApi.getToken());

        String result = HttpUtil.execute(url,HttpUtil.get(menuJson));
        return result;
    }

}
