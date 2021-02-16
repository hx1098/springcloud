package com.mashibing.eurekaserver;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hx
 * @createTime 2020/12/24 14:51
 * @option
 * @description
 */
//@RequestMapping("User")
public interface UserApi {

    /**
     * 测试
     * @return lalala
     */
    @GetMapping("User/alive")
    String isAlive();

    @GetMapping("User/getById")
    Integer getById(@RequestParam("id") Integer id);


}
