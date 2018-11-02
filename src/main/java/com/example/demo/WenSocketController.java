package com.example.demo;


import com.example.demo.netty.Constant;
import com.example.demo.netty.MyNettyHandler;
import com.example.demo.netty.Person;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/wss")
public class WenSocketController {

    @Autowired

    @RequestMapping("/send")
    public String sendAll() {

        for (Map.Entry<String, MyNettyHandler> map : Constant.getAll().entrySet()) {
            System.out.println("map.getKey=" + map.getKey());
            map.getValue().getCtx().channel().writeAndFlush(new TextWebSocketFrame(map.getKey() + "你好！"));
        }
        return "SUCCESS";
    }

    @RequestMapping("/getIp")
    public String getIp() {
        return Constant.ip;
    }

    @RequestMapping("/test/cookie")
    public String cookie(@RequestParam(name = "browser", required = false) String browser, HttpServletRequest request, HttpSession session) {
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "index";
    }

}
