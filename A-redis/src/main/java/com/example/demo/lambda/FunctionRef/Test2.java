package com.example.demo.lambda.FunctionRef;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author hx
 * @createTime 2021/9/21 11:00
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 11:00
 * @editDescription  静态方法引用
 *
 */
public class Test2 {

    static String put() {
        System.out.println("put ...........");
        return "put";
    }
    public static void main(String[] args) {
        System.out.println(put());
        System.out.println("===========================");

        Supplier<String> supplier = ()->put();
        System.out.println(supplier.get());

        System.out.println("===========================");
        Supplier<String> supplier1 = Test2::put;
        System.out.println(supplier1.get());

        System.out.println("=================");
        /*返回数据的函数*/
        Supplier<String> supplier2 = Fun::hehe;
        System.out.println(supplier2.get());

        /*传入参数的函数*/
        System.out.println("=================");
        Consumer<String> consumer = Test2::getSize;
        //以前的写法:
        Consumer<String> consumer1 = s -> Test2.getSize(s);


        System.out.println("=================");
        Function<String, String> function = (s)->{return Test2.toUpperCase(s);};
        Function<String, String> function1 = s -> s.toUpperCase();
        Function<String, String> function2 = s -> Test2.toUpperCase(s);

        System.out.println(function.apply("abc"));
        System.out.println(function1.apply("abc"));
        System.out.println(function2.apply("abc"));



        System.out.println("'========================");
        /*三个参数的function*/
        BiFunction<String, String, Integer> biFunction = (a, b) -> a.length() + b.length();
        BiFunction<String,String,Integer> biFunction1 = Test2::getLength;
        //静态方法引用
        System.out.println(biFunction1.apply("qwe", "345"));



    }


    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static Integer getLength(String str1, String str2) {
        return str1.length() + str2.length();
    }

    public static void getSize(String s) {
        System.out.println("getSize");
    }
    static class Fun {
        public static String hehe() {
            System.out.println("hehe...");
            return "hehe";
        }
    }

}
