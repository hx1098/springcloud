package com.example.demo.lambda.FunctionRef;/**
 * @author yd
 * @date 2021/9/21 15:04
 * @version 1.0
 */

import org.omg.CORBA.INTERNAL;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author hx
 * @createTime 2021/9/21 15:04
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 15:04
 * @editDescription
 */
public class Test5 {

    public static void main(String[] args) {
        Supplier<Person> supplier = ()->new Person();
        supplier.get();

        Supplier<Person> supplier1 = Person::new;
        supplier1.get();
        System.out.println("===========================");

        Supplier<List> supplier2 = ArrayList::new;

        Supplier<Set> supplier3 = TreeSet::new;
        Supplier<Set> supplier4 = HashSet::new;
        Supplier<Thread> threadSupplier = Thread::new;
        Supplier<String> stringSupplier = String::new;

        //因为integer 的构造方法必须楚传入一个参数, 所以他的构造里面不能Integer::new 这样的写法
        //Supplier<Integer> integerSupplier = Integer::new;


        //这里是可以传入参数的....
        Consumer<Integer> consumer = (age) -> new Account(age);
        Consumer<Integer> consumer1 = Account::new;
        consumer1.accept(45);


        System.out.println("========================");
        Function<String, Account> function = (str) -> new Account(str);
        Function<String, Account> function1 = Account::new;
        System.out.println(function1.apply("43534"));


    }

   static class Account {
        public Account() {
            System.out.println("调用无参构造方法");
        }
        public Account(int age) {
            System.out.println("调用age构造方法");
        }
        public Account(String str) {
            System.out.println("调用str构造方法");
        }
    }

    static class Person{
        public Person(){
            System.out.println("调用无参person 构造方法!");
        }
    }
}
