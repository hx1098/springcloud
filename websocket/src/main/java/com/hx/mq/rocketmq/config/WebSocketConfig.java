package com.hx.mq.rocketmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/3 13:58
 * @description
 * @editUser hx
 * @editTime 2021/12/3 13:58
 * @editDescription 开启websocket的支持
 *
 * 参考：
 * https://blog.csdn.net/moshowgame/article/details/80275084
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
