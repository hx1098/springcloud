package com.hx.retry.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.remoting.RemoteAccessException;

import java.util.Random;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/24 9:20
 * @description
 * @editUser hx
 * @editTime 2021/11/24 9:20
 * @editDescription
 */
@Slf4j
public class RetryDemoTask {
    public static boolean retryTask(String param)  {
        log.info("收到请求参数:{}",param);

        int i = new Random().nextInt(11)+2;
        log.info("随机生成的数:{}",i);
        return false;
        /*if (i < 2) {
            log.info("为0,抛出参数异常.");
            throw new IllegalArgumentException("参数异常");
        }else if (i  < 5){
            log.info("为1,返回true.");
            return true;
        }else if (i < 7){
            log.info("为2,返回false.");
            return false;
        }else{
            //为其他
            log.info("大于2,抛出自定义异常.");
            throw new RemoteAccessException("大于2,抛出自定义异常");
        }*/
    }

}


