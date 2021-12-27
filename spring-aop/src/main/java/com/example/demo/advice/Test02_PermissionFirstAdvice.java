package com.example.demo.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.LongToIntFunction;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/27 10:17
 * @description
 * @editUser hx
 * @editTime 2021/12/27 10:17
 * @editDescription
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class Test02_PermissionFirstAdvice {

    /**
     * 定义一个切面,括号内写入第一步中自定义注解的路径
     */
    @Pointcut("@annotation(com.example.demo.annotation.PermissionAnnotation)")
    private void permissionCheck() {

    }

    @Around("permissionCheck()")
    public Object permissionCheckList(ProceedingJoinPoint  joinPoint) throws Throwable {

        /**
         * 这里的参数只能是: (JSONObject) args[0] 只能从[0]中过去, 不能从[1],[2]中获取,
         */
        log.info("第一个切面::joinPoint = [{}]",joinPoint);
        Object[] args = joinPoint.getArgs();
        Long id = ((JSONObject) args[0]).getLong("id");
        String name1 = ((JSONObject) args[0]).getString("name");

        log.info("第一个切面::id = [{}], name = [{}]",id,name1);

        if (id < 0) {
            return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
        }
        return joinPoint.proceed();
    }






}
