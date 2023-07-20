//package com.xing.studyboot.webSocket;
//
//import javax.websocket.OnClose;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.PathParam;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//public class WebSocketHandler extends TextWebSocketHandler {
//
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//    	System.out.println("xxx");
//        // 处理接收到的文本消息
//        String receivedMessage = message.getPayload();
//        // 处理逻辑...
//        
//        // 发送消息到客户端
//        String responseMessage = "Hello, client!";
//        session.sendMessage(new TextMessage(responseMessage));
//    }
//    // 其他WebSocket事件的处理方法可以在此处添加，例如连接建立、连接关闭等
//    /**
//     * * 连接建立后触发的方法
//     */
//    @OnOpen
//    public void onOpen(@PathParam("oid") String oid, WebSocketSession session) {
//        System.out.println("onOpen=====" + oid);
////        WebSocketMapUtil.put(oid, session);
//    }
//    /**
//     * * 连接关闭后触发的方法
//     */
//    @OnClose
//    public void onClose() {
//        System.out.println("====== onClose ======");
//    }
//}