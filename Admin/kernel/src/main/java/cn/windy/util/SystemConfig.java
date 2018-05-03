package cn.windy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class SystemConfig {


    private static Logger log = LoggerFactory.getLogger(SystemConfig.class);
    private static Properties properties = System.getProperties();

    static{
        try {
            properties.load(SystemConfig.class.getResourceAsStream("/application.properties"));
            //log.info("加载配置文件：{}"+properties);
        } catch (IOException e) {
            log.error("加载配置文件出错：",e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key,"");
    }

    public static boolean getBoolean(String key){
        String value = get(key);
        if(StringUtil.isBlank(value)){
            return false;
        }else{
            if("true".equalsIgnoreCase(value)){
                return true;
            }
            return false;
        }
    }

    public static int getInt(String key){
        String value = get(key);
        if(StringUtil.isBlank(value)){
            return 0;
        }else{
            if(StringUtil.isNumber(value))
                return Integer.parseInt(value);
            return 0;
        }
    }

}
