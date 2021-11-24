package com.hx.retry.test;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/24 9:19
 * @description
 * @editUser hx
 * @editTime 2021/11/24 9:19
 * @editDescription testRetry
 */
@Slf4j
public class TestRetry {


    /**
     * 封装guava实现重试
     * @param clazz 设置异常重试源
     * @param bool 根据结果进行重试
     * @param time 设置时间间隔
     * @param timeUnit 设置时间间隔单位
     * @param count 一共请求几次, 包含第一次请求的次数
     * @return
     */
    public static Retryer<Boolean> retryReturnBoolan(Class<Exception> clazz, boolean bool, int time, TimeUnit timeUnit, int count) {
       return RetryerBuilder.<Boolean>newBuilder()
                //设置异常重试源
                .retryIfExceptionOfType(clazz)
                //根据结果进行重试
                .retryIfResult(res -> res == bool)
                //设置时间间隔
                .withWaitStrategy(WaitStrategies.fixedWait(time, timeUnit))
                //设置最大重试次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(count))
                .build();
    }

    @SneakyThrows
    @Test
    public void test1(){
       /* Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                //设置异常重试源
                .retryIfExceptionOfType(RemoteAccessException.class)
                //根据结果进行重试
                .retryIfResult(res -> res == false)
                //设置时间间隔
                .withWaitStrategy(WaitStrategies.fixedWait(5, TimeUnit.SECONDS))
                //设置最大重试次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        */
        Retryer<Boolean> retryer = TestRetry.retryReturnBoolan(Exception.class, false, 5, TimeUnit.SECONDS, 3);
        Boolean abc = retryer.call(() -> RetryDemoTask.retryTask("abc"));


    }

}
