package com.mashibing.eurekaserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author hx
 * @createTime 2020/12/24 22:49
 * @option
 * @description
 */
//此方法,不结合eureka,自定义一个client名字,就用url树形来指定服务器列表,
//@FeignClient(name = "user-provider",fallback = UserProviderBack.class)
@FeignClient(name = "user-provider",fallbackFactory = UserProviderBacktoryFactory.class)
public interface ConsumerAPI  extends UserApi{
    //继承之后, 都不需要写了


    /**
     * 如果想写自己顶一个的, 就直接在这里面写就行了
     * @param id
     * @return
     */
    @GetMapping("/getMap")
    Map<Integer,String> getMap(@RequestParam("id") Integer id);


    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);

    @PostMapping("/postPerson")
    public Person postPerson(@RequestBody Person person);
}
