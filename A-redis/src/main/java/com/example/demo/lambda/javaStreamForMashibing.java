package com.example.demo.lambda;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @author hx
 * @createTime 2021/5/8 6:34
 * @option
 * @description
 */
public class javaStreamForMashibing {

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
        System.out.println(callable.call());
        ;

        Callable<String> callable1 = () -> {
            return "callable1";
        };
        System.out.println(callable1.call());

        Callable<String> callable2 = () -> "callable2";
        System.out.println(callable2.call());

        Studentdao dao = new Studentdao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入数据....");
            }
        };
        dao.insert(new Student("1", 2, 1));

        Studentdao studentdao = (s) -> {
            System.out.println(s);
        };

        Studentdao studentdao1 = (Student s) -> System.out.println("student");


    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("zhg", "12324", "wangwu", "woperuewio", "23", "sjdoifh");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Studentdao studentdao = new Studentdao() {
            @Override
            public void insert(Student student) {
                System.out.println("insert....");
            }
        };
        studentdao.insert(new Student());


        Studentdao studentdao1 = (student -> System.out.println("insert..."));

        Studentdao studentdao2 = s -> System.out.println("insert...");
    }


   /**
    * @param  null
    * @description
    * @author hx
    * @date 2021/5/27 22:48
    * @return 
    * @throws 
    */
    @Test
    public void test3() {
        Teacherdao teacherdao = new Teacherdao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }
        };

        Teacherdao teacherdao1 = teacher -> {return 2;};

        Teacherdao teacherdao2 = (Teacher teacher) -> {return 3;};

        Teacherdao teacherdao3 = teacher -> 4;

        Teacherdao teacherdao4 = (Teacher teacher)->5;

        System.out.println(teacherdao.get(new Teacher()));
        System.out.println(teacherdao1.get(new Teacher()));
        System.out.println(teacherdao2.get(new Teacher()));
        System.out.println(teacherdao3.get(new Teacher()));
        System.out.println(teacherdao4.get(new Teacher()));


    }



    public Teacher getString(String a,String b){
        return new Teacher();
    }


}
