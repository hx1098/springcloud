package com.example.demo.lambda;

import java.util.concurrent.Callable;

/**
 * @author hx
 * @createTime 2021/5/8 6:34
 * @option
 * @description
 */
public class javaStream01 {

    public String put() {
        return "put...";
    }

    public static void main(String[] args) throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("'111123456789");
            }
        };
        runnable.run();


        Runnable runnable1 = () -> {
            System.out.println("123");
        };
        runnable1.run();

        Runnable runnable2 = () -> System.out.println("234567890");
        runnable2.run();


        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                return "callable.call";
            }
        };
        System.out.println(callable.call());;

        Callable<String> callable1 = ()->{return "callable1";};
        System.out.println(callable1.call());

        Callable<String> callable2 = ()->"callable2";
        System.out.println(callable2.call());

        Studentdao dao = new Studentdao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入数据....");
            }
        };
        dao.insert(new Student());

        Studentdao studentdao = (s)->{
            System.out.println(s);
        };

        Studentdao studentdao1 = (Student s) -> System.out.println("student");

    }

}
