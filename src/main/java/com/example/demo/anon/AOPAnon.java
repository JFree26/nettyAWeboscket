package com.example.demo.anon;

import java.lang.annotation.*;

/**
 * Copyright 2018 济中节能 All rights reserved.
 * Created by LiLei on 2018/9/10 16:14.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AOPAnon {
    String value() default "";

    int num() default 0;
}
