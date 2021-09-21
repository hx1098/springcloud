package com.example.demo.lambda.test;

import java.util.concurrent.Callable;

/**
 * @author hx
 * @createTime 2021/9/21 9:46
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 9:46
 * @editDescription
 */
public class LambdaTest2 {

    public static void main(String[] args) throws Exception {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runabble ....");
            }
        };
        runnable.run();

        Runnable runnable1 = ()->{
            System.out.println("123");
        };
        runnable1.run();

        Runnable runnable2 = ()-> System.out.println("run...");
        runnable2.run();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "234";
            }
        };
        System.out.println(callable.call());

        Callable<String> stringCallable = () -> "sout";
        Callable<String> stringCallable2 = () -> {
            return "sout";
        };







    }

}
