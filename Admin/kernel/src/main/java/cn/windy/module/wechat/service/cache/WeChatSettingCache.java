package cn.windy.module.wechat.service.cache;

import cn.windy.annotation.Cache;
import cn.windy.kernel.spring.SpringUtil;
import cn.windy.module.wechat.model.WeChatSetting;
import cn.windy.module.wechat.service.IWeChatSettingService;

import java.util.HashMap;
import java.util.Map;

@Cache
public class WeChatSettingCache {

    private static Map<String,WeChatSetting> map = new HashMap<>();

    public static void put(WeChatSetting weChatSetting){
        map.put("weChatSetting",weChatSetting);
    }

    static IWeChatSettingService weChatSettingService = SpringUtil.getBean("weChatSettingService");

    public static WeChatSetting getSetting(){
        WeChatSetting weChatSetting = map.get("weChatSetting");
        if(weChatSetting == null){
            weChatSetting = weChatSettingService.findById(1L);
            put(weChatSetting);
        }
        return weChatSetting;
    }

    public static void clear() {
        map.clear();
    }

}
