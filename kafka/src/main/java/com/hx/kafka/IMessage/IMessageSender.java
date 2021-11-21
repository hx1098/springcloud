package com.hx.kafka.IMessage;

/**
 * @author hx
 * @createTime 2021/11/21 13:42
 * @option
 * @description
 */
public interface IMessageSender {
    public void sendMessage(String topic, String key, String message);
}
