package com.example.demo.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/27 9:55
 * @description
 * @editUser hx
 * @editTime 2021/12/27 9:55
 * @editDescription
 * https://blog.csdn.net/mu_wind/article/details/102758005
 */
@Aspect
@Component
@Slf4j
public class Test01_LogAdvice {

    /**
     * 定义一个切点,
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointCut() {

    }

    @Before("logAdvicePointCut()")
    public void logAdvice() {
       log.info("logAdvice::get请求的advice触发了...");
    }


}
