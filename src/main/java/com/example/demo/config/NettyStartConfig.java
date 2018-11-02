package com.example.demo.config;

import com.example.demo.netty.NettyServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NettyStartConfig implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        new Thread(() -> {
            try {
                new NettyServer(32119).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
