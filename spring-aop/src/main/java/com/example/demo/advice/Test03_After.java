package com.example.demo.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/27 13:50
 * @description
 * @editUser hx
 * @editTime 2021/12/27 13:50
 * @editDescription
 */
@Aspect
@Slf4j
@Component
public class Test03_After {

    /**
     * 拦截所有的controller,
     */
    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void pointCut(){}


    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("doAfter::方法进入了..... ");

        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        log.info("方法[{}]::执行完了.....",name);


    }
}
