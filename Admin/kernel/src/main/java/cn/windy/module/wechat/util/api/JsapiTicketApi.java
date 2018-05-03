package cn.windy.module.wechat.util.api;

import cn.windy.module.wechat.util.HttpUtil;
import cn.windy.module.wechat.util.api.bean.JsapiTicket;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsapiTicketApi {

    private static Map<String,JsapiTicket> map = new HashMap<>();

    public static String execute(){
        JsapiTicket ticket = map.get("JsapiTicket");
        if(ticket == null || ticket.getTicket() == null || ticket.isExpired()){
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";
            url = String.format(url, AccessTokenApi.getToken());
            String JsapiTicketJson = HttpUtil.execute(url,null);
            JSONObject object = (JSONObject) JSON.parse(JsapiTicketJson);
            ticket = new JsapiTicket(object.getString("ticket"),object.getIntValue("expires_in"));
            map.put("JsapiTicket",ticket);
        }
        return ticket.getTicket();
    }

}
