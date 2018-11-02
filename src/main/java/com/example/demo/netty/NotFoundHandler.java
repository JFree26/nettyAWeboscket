package com.example.demo.netty;

import com.example.demo.common.DateUtil;

import java.time.LocalDateTime;

public class NotFoundHandler implements ActionHandler {


    @Override
    public Message action(Message message) {
        Message outMessage = new Message();
        outMessage.setActionType(400);
        outMessage.setValue("请求类型不存在");
        outMessage.setTime(LocalDateTime.now());
        outMessage.setStrTime(DateUtil.localDateTimeToString(outMessage.getTime()));
        return outMessage;
    }
}
