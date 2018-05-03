package cn.windy.kernel.controller;

import cn.windy.kernel.UserConfig;
import cn.windy.kernel.model.User;
import cn.windy.redis.JedisUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * controller基类
 * @author zhzw
 */
public class BaseController {

    @Value("${dev.model}")
    public boolean devModel;

    public HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public HttpSession getSession(){
        return getRequest().getSession();
    }

    public void putSession(String key,Object obj){
        getSession().setAttribute(key,obj);
    }

    public Object getSession(String key){
        return getSession().getAttribute(key);
    }

    public String getUserJson(String token){
        String sessionJson = JedisUtil.get(token);
        return sessionJson;
    }

    public User getUser(String token){
        String sessionJson =getUserJson(token);
        User user = JSON.parseObject(sessionJson,User.class);
        return user;
    }

    public UserConfig getUserConfig(String token){
        User user = getUser(token);
        String userConfigJson = JedisUtil.get("UserConfig:"+user.getPhone());
        return JSON.parseObject(userConfigJson,UserConfig.class);
    }
}
