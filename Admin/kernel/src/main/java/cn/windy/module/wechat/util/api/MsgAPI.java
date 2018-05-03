package cn.windy.module.wechat.util.api;

import cn.windy.module.wechat.util.HttpUtil;
import org.apache.http.entity.StringEntity;
import org.slf4j.LoggerFactory;

import java.nio.charset.UnsupportedCharsetException;

/**
 * Created by zhangzunwei on 15/5/27.
 */
public class MsgAPI {

    public static String send(String openid,String text){
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+ AccessTokenApi.getToken();

        //转为xml
        String json = "{\"touser\":\"%s\",\"msgtype\": \"text\",\"text\": { \"content\": \"%s\"}}";
        try {
            return HttpUtil.execute(url, new StringEntity(String.format(json, openid, text), "utf-8"));
        } catch (UnsupportedCharsetException e) {
            LoggerFactory.getLogger(MsgAPI.class).error("SendMsg error:{}", e.getMessage());
        }
        return "";
    }

    //开始充电
    public static String sendStartChargingMsg(String openId,String startTime,String type,String code){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+AccessTokenApi.getToken();
        String msg = " {\n" +
                "           \"touser\":\"%s\",\n" +
                "           \"template_id\":\"DUXhIJ71x-qmPt0M4RtgZViAV8epQxx0oIungwEwIzM\",\n" +
                "           \"url\":\"\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"开始充电，欢迎您的使用！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"开始充电，欢迎您的使用！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        try {
            return HttpUtil.execute(url,HttpUtil.get(String.format(msg,openId,startTime,type,code)));
        } catch (UnsupportedCharsetException e) {
            LoggerFactory.getLogger(MsgAPI.class).error("SendMsg error:{}", e.getMessage());
        }

        //添加数据库下发记录

        return "";
    }

    //

    /**
     * 充电异常
     * @param openId 用户id
     * @param message 异常
     * @param type 异常类型
     * @param time
     * @param code
     * @return
     */
    public static String sendChargingAbnormalMsg(String openId,String message,String type,String time,String code){

        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+AccessTokenApi.getToken();
        String msg = " {\n" +
                "           \"touser\":\"%s\",\n" +
                "           \"template_id\":\"eY7G61jTU7rozeoInjDaJw1YIrmkSskppWGWNiSAcrw\",\n" +
                "           \"url\":\"\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"充电异常！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        try {
            return HttpUtil.execute(url,HttpUtil.get(String.format(msg,openId,message,type,time,code)));
        } catch (UnsupportedCharsetException e) {
            LoggerFactory.getLogger(MsgAPI.class).error("SendMsg error:{}", e.getMessage());
        }
        return "";
    }

    //结束充电
    public static String sendEndChargingMsg(String openId,String dingDanHao,String money,String endTime,String code){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+AccessTokenApi.getToken();
        String msg = " {\n" +
                "           \"touser\":\"%s\",\n" +
                "           \"template_id\":\"LuthFkZGojpQCchYy4yyRmCJTDfbVihCsOd3qpK_FTw\",\n" +
                "           \"url\":\"\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"结束充电，谢谢您的使用！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword4\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"结束充电，谢谢您的使用！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        try {
            return HttpUtil.execute(url,HttpUtil.get(String.format(msg,openId,dingDanHao,money,endTime,code)));
        } catch (UnsupportedCharsetException e) {
            LoggerFactory.getLogger(MsgAPI.class).error("SendMsg error:{}", e.getMessage());
        }
        return "";
    }

    //结算提醒
    public static String sendBillMsg(String openId,String sc,String billStandard,String bill,String balance,String equCode){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+AccessTokenApi.getToken();
        String msg = " {\n" +
                "           \"touser\":\"%s\",\n" +
                "           \"template_id\":\"XYTxA_AlNPUVa91GTHyJmDeJEcAOE0yXeAXUTPqHwcE\",\n" +
                "           \"url\":\"\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"结算提醒，感谢您的使用！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword4\":{\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword5\": {\n" +
                "                       \"value\":\"%s\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"结算提醒，感谢您的使用！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        try{
            return HttpUtil.execute(url,HttpUtil.get(String.format(msg,openId,sc,billStandard,bill,balance,equCode)));
        } catch (UnsupportedCharsetException e){
            LoggerFactory.getLogger(MsgAPI.class).error("SendMsg error:{}",e.getMessage());
        }
        return "";
    }

}