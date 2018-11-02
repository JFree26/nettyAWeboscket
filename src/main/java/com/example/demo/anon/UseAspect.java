package com.example.demo.anon;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class UseAspect {
    final static Logger log = LoggerFactory.getLogger(UseAspect.class);

    @Pointcut("@annotation(com.example.demo.anon.AOPAnon)")
    public void sd() {

    }


    @Around("sd()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("开始");
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //从切面中获取当前方法
        Method method = signature.getMethod();

        //得到了方,提取出他的注解
        AOPAnon aopAnon = method.getAnnotation(AOPAnon.class);
        log.info("  aopAnon.num()=" + aopAnon.num());
        log.info("aopAnon.value()=" + aopAnon.value());

        try {
           Object o =proceedingJoinPoint.proceed();
           log.info("o="+o);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("结束");

    }
}
