package com.example.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/7/22 15:27
 * @option
 * @description
 * @editUser hx
 * @editTime 2021/7/22 15:27
 * @editDescription  两个线程在执行的时候, 如果不加volatile, a线程中保留了一份copy,如果b线程修改了该变量,a线程未必知道,
 *      如果加上之后, a线程如果改变了了running 对象, b线程是可以感知到的, 随机将while循环停止了.
 *
 *      但是: volatile 并不能保证多个线程共同修改running 带来的数据不一致问题,也就是说volatile不能代替synchronized
 */
public class TestVolitile {

    volatile boolean running = true;

    void m(){
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m ending");

    }

    public static void main(String[] args) {
        TestVolitile volitile = new TestVolitile();
        new Thread(volitile::m).start();

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("开始执行........");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        volitile.running = false;
    }

}
