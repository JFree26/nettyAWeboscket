package com.example.demo;

import com.example.demo.rabbitmq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rabbit/{text}")
public class RabbitController {

    @Autowired
    private Sender sender;

    @GetMapping("/send")
    public String send(@PathVariable("text") String text, HttpServletRequest request, String msg) {
        sender.send(msg);
        System.out.println("text==---" + text);
        return "send OK!";
    }

}
