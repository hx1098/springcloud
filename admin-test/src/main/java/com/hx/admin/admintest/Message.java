package com.hx.admin.admintest;

/**
 * @author hx
 * @createTime 2021/4/21 21:27
 * @option
 * @description
 */
public class Message {

    private String msgtype;
    private MessageInfo text;
    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    public MessageInfo getText() {
        return text;
    }
    public void setText(MessageInfo text) {
        this.text = text;
    }
}
