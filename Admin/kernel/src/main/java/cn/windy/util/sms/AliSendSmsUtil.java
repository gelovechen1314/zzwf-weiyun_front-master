package cn.windy.util.sms;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发送短信类
 * @author Wangxk
 */
public class AliSendSmsUtil {

    private static Logger log = LoggerFactory.getLogger(AliSendSmsUtil.class);

    /**
     *
     * 发送验证码 
     * @param mobile 手机号
     * @return
     * @throws ClientException
     */
    public static String sendSmsBymobile(String mobile) {
        int ran = (int) (Math.random() * 900000) + 100000;// 随机生成大于或等于100000小于1000000 的数
        SendSmsResponse sendResult = null;
        try {
            sendResult = sendSms(mobile, "友电充", "SMS_86780049",
                    "{\"name\":\"Tom\", \"code\":\"" + ran + "\"}");
        } catch (ClientException e) {
            log.error("发送短信异常{}",e);
        }
        if (sendResult.getCode() != null && sendResult.getCode().equals("OK")) {
            return ran + "";
        }
        return "false";
    }



    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    static final String accessKeyId = "LTAIupdkbqr2jyiy";
    static final String accessKeySecret = "gosW8wq3gMLCZrEdmEmslAuyR3ZWKC";

    public static SendSmsResponse sendSms(String cellphone,String signName,String templateCode,String templateParam) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(cellphone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(templateParam);

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

}
