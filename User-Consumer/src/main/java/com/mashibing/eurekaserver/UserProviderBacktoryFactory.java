package com.mashibing.eurekaserver;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hx
 * @createTime 2021/2/16 21:48
 * @option   有详细信息
 * @description UserProviderBacktoryFactory
 */
@Component
public class UserProviderBacktoryFactory implements FallbackFactory<ConsumerAPI> {


    @Override
    public ConsumerAPI create(Throwable cause) {

        return new ConsumerAPI() {
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

            @Override
            public String isAlive() {
                System.out.println("11111");
                System.out.println(cause);
                System.out.println(ToStringBuilder.reflectionToString(cause));
                cause.printStackTrace();
                if(cause instanceof FeignException.InternalServerError){

                    return "远程服务器5000" + cause.getLocalizedMessage();
                }
                return "呵呵";
            }

            @Override
            public Integer getById(Integer id) {
                return null;
            }
        };
    }
}
