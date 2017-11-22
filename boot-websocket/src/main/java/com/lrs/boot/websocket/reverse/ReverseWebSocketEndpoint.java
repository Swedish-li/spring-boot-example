package com.lrs.boot.websocket.reverse;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 浏览器提供的 websocket 接口
 */
@ServerEndpoint("/reverse")
public class ReverseWebSocketEndpoint {

    @OnMessage
    public void handleMessage(Session session, String msg) throws IOException {
        session.getBasicRemote()
                .sendText("Reversed:" + new StringBuilder(msg).reverse());
    }
}
