package com.lrs.boot.websocket.echo;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoWebsocketHandler extends TextWebSocketHandler {

    // 建立连接时执行
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("opened new session in instance " + this);
    }

    // 接收并响应信息
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();
        System.out.println(msg);
        session.sendMessage(new TextMessage(msg));
    }

    // 错误处理
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        exception.printStackTrace();
        session.close(CloseStatus.SERVER_ERROR);
    }
}
