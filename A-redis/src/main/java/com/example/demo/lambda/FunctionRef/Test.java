package com.example.demo.lambda.FunctionRef;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author hx
 * @createTime 2021/9/21 11:00
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 11:00
 * @editDescription
 */
public class Test {
    public static void main(String[] args) {

        Function<String, Integer> function = (string) -> {
            return 23;
        };
        System.out.println(function.apply("234234"));


        Consumer<String> consumer = (str) -> {
            System.out.println(str);
        };
        consumer.accept("123456");


    }
}
