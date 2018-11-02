//package com.example.demo.websocket;
//
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@ServerEndpoint("/wss/{wId}")
//@Component
//public class WebsocketSession {
//    private static AtomicInteger onLineNumber = new AtomicInteger(0);
//
//    private final static Map<Long, WebsocketSession> online = new ConcurrentHashMap();
//
//    private Session session;
//
//    private Long wId;
//
//    @OnOpen
//    public void onOpen(Session session, @PathParam("wId") Long wId) {
//        this.session = session;
//        this.wId = wId;
//        online.put(wId, this);
//        System.out.println("wId=" + wId + "连接成功");
//
//    }
//
//    @OnClose
//    public void onClose() {
//        System.out.println("oncla=" + this.toString());
//        online.remove(this.getwId());
//        System.out.println("wId=" + wId + "连接关闭");
//        try {
//            this.session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public Long getwId() {
//        return wId;
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        System.out.println("----客户端" + wId + "发送的消息:" + message);
//    }
//
//    @OnError
//    public void onError(Session session, Throwable throwable) {
//        System.out.println("wid=" + wId + "报错" + throwable.toString());
//    }
//
//
//    public static void sendAll(String message) {
//        for (Map.Entry<Long, WebsocketSession> map : online.entrySet()) {
//            map.getValue().sendMessage(message);
//        }
//    }
//
//    public void sendMessage(String message) {
//        try {
//            this.session.getBasicRemote().sendText(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "WebsocketSession{" +
//                "session=" + session +
//                ", wId=" + wId +
//                '}';
//    }
//}
