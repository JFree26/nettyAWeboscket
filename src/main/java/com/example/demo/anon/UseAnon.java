package com.example.demo.anon;

import org.springframework.stereotype.Component;



@Component
public class UseAnon {

    @AOPAnon(value = "ut1", num = 12)
    public void useAnon(Integer id, String value) {

    }
}
