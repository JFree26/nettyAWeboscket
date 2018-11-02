package com.example.demo.netty;

import com.example.demo.common.DateUtil;

import java.time.LocalDateTime;

public class TestHandler implements ActionHandler {



    @Override
    public Message action(Message inMsg) {
        Message outMessage = new Message();
        outMessage.setActionType(inMsg.getActionType());
        outMessage.setValue("具体业务的操作:TestHandler");
        outMessage.setTime(LocalDateTime.now());
        outMessage.setStrTime(DateUtil.localDateTimeToString(outMessage.getTime()));
        return outMessage;
    }


}
