package com.example.demo.lambda.test;

import com.example.demo.lambda.Teacher;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;

import java.util.function.*;

/**
 * @author hx
 * @createTime 2021/9/21 10:00
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 10:00
 * @editDescription
 */
public class StudentLambdaTest {

    public static void main(String[] args) {

        Studentdao studentdao = new Studentdao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入学生!");
            }
        };

        Studentdao studentdao1 = (s) -> {
            System.out.println("插入学生....");
        };


        Studentdao studentdao2 = (Student stucent) -> {
            System.out.println("插入学生...");
        };

       /* Teacherdao teacherdao = new Teacherdao() {
            @Override
            public int insert() {
                return 0;
            }
        };*/

        Teacherdao teacherdd = (e) -> {
            return 1;
        };
        Teacherdao teacherdd2 = (Teacher teacher) -> {
            return 9;
        };
        Teacherdao teacherdao = (t) -> 3;
        Teacherdao teache = (Teacher tea) -> 5;

        Function<String, Integer> function = (str) -> {
            return str.length();
        };
        System.out.println(function.apply("abdkjhfds"));

        Supplier<String> supplier = () -> {
            return "jsodfosdi".toString();
        };
        System.out.println(supplier);


        Consumer<String> consumer = (s)->{
            System.out.println(s);
        };
        consumer.accept("str");


        System.out.println("=====================");
        Runnable runnable = ()->{
            int i = get();
            System.out.println(i);
        };
        runnable.run();


        System.out.println("===================");
        /*
        * 前两个为输入的参数, 第三个是输出的参数类型.
        * */
        BiFunction<String,String,Integer> bf = (a,b)->a.length()+ b.length();
        Integer apply = bf.apply("12", "34");
        System.out.println(apply);


    }

    static int get() {
        return 1;
    }
}