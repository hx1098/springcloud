package com.example.demo.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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
public class Test04_AfterReturning {

    /**
     * 拦截所有的controller,
     */
    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void pointCut(){}

    /**
     * AfterReturning 与   After 的区别是: AfterReturning 可以获取返回参数, 但After不能获取其中的参数.
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void doAfter(JoinPoint joinPoint,Object result) {
        log.info("doAfter::方法进入了..... ");

        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        log.info("执行过程.......");


        log.info("doAfter方法[{}]::执行完返回参数.....",result);


    }
}
