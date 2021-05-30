package com.example.demo.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/25 22:32
 * @option
 * @description
 */
public class JavaStream03 {


    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 24, 70));
        list.add(new Student("lisi", 23, 45));
        list.add(new Student("wangwu", 18, 69));
        list.add(new Student("maliu", 26, 25));
        list.add(new Student("zhaosi", 24, 90));
        list.add(new Student("liuchang", 17, 98));
        list.add(new Student("wang", 21, 86));
        list.add(new Student("jichang", 20, 83));

        list.stream().filter(student -> student.getAge() > 20).forEachOrdered(System.out::println);

        list.stream().filter(student -> student.getAge() > 20).forEach(student -> System.out.println());

        list.parallelStream();
    }

}
