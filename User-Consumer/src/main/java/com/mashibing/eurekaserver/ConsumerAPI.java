package com.mashibing.eurekaserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hx
 * @createTime 2020/12/24 22:49
 * @option
 * @description
 */
//此方法,不结合eureka,自定义一个client名字,就用url树形来指定服务器列表,
@FeignClient(name = "user-provider")
public interface ConsumerAPI  extends UserApi{
    //继承之后, 都不需要写了
}
