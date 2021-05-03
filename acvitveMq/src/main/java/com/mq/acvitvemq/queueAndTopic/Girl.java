package com.mq.acvitvemq.queueAndTopic;

import java.io.Serializable;

/**
 * @author hx
 * @createTime 2021/5/2 15:35
 * @option
 * @description
 */
public class Girl  implements Serializable {


    private String name;
    private String age;
    private String price;


    public Girl(String name, String age, String price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    /**
     * name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * age
     *
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * age
     *
     * @param age age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * price
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * price
     *
     * @param price price
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
