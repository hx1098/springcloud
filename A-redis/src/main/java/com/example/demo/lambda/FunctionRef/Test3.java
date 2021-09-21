package com.example.demo.lambda.FunctionRef;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author hx
 * @createTime 2021/9/21 13:51
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 13:51
 * @editDescription 实例方法引用
 */
public class Test3 {

    public String put() {
        return "put...";
    }
    public void getSize(String s) {
        System.out.println("getSize()");
        return;
    }

    public static void main(String[] args) {

        System.out.println(new Test3().put());
        Supplier<String> stringSupplier = () -> new Test3().put();
        Supplier<String> supplier = new Test3()::put;
        System.out.println(supplier.get());

        System.out.println("========================");
        //创建一个Test3对象,
        Test3 test3 = new Test3();
        Consumer<String> consumer = x->new Test3().getSize(x);
        Consumer<String> consumer1 = new Test3()::getSize;
        consumer.accept("stre");
        Consumer<String> consumer2 = test3::getSize;










    }

}
