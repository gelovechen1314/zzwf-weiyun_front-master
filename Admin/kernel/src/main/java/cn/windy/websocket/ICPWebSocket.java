package cn.windy.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value = "/weChat/mp/webSocket")
@Component
public class ICPWebSocket {
    private static Logger log = LoggerFactory.getLogger(ICPWebSocket.class);

    private static Map<String,Session> webSocketMap = new HashMap<>();

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session) {
        log.info("用户打开...{}",session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        log.info("用户离开...");

    }

    /**
     * 收到客户端消息后调用的方法
     * 客户端只在连接上后发送一条消息，就当前的用户名
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息:{}" , message);
        if(message.startsWith("User:"))
            webSocketMap.put(message,session);
    }

    public static void send(String openid,String message)  {
        Session session = webSocketMap.get("User:"+openid);
        try {
            if(session != null && session.isOpen())
                session.getBasicRemote().sendText(message);
            else
                log.error("没有当前登录的用户会话，不再推送消息......");
        } catch (Exception e) {
            log.error("发送消息错误{}",e);
        }
    }

}
