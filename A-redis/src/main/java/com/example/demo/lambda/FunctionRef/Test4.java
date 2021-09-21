package com.example.demo.lambda.FunctionRef;/**
 * @author yd
 * @date 2021/9/21 14:52
 * @version 1.0
 */

import java.util.function.Consumer;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/21 14:52
 * @description
 * @editUser hx
 * @editTime 2021/9/21 14:52
 * @editDescription
 */
public class Test4 {

    public static void main(String[] args) {
        Consumer<Too> consumer = too -> new Too().foo();
        consumer.accept(new Too());


        System.out.println("============");
        Consumer<Too> consumer1 = Too::foo;
        consumer1.accept(new Too());




    }

    static class Too {
        public Integer fun(String s) {
            return 1;
        }

        public void foo() {
            System.out.println("foo");
        }
    }

    static class Too2 {
        public Integer fun(String s) {
            return 2;
        }

        public void foo() {
            System.out.println("foo2");
        }

        public void show() {
            System.out.println("void show");
        }
    }


}
