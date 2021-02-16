package com.mashibing.eurekaserver;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hx
 * @createTime 2021/2/15 23:32
 * @option
 * @description
 */
@Component
public class UserProviderBack implements ConsumerAPI{

    @Override
    public String isAlive() {
        return "降级了!!!";
    }

    @Override
    public Integer getById(Integer id) {
        return null;
    }


    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }
}
