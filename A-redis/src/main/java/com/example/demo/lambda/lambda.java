package com.example.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/21 9:20
 * @description
 * @editUser hx
 * @editTime 2021/9/21 9:20
 * @editDescription
 */
public class lambda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("list", "string", "map", "tree");
        Collections.sort(list, (a, b) -> a.length() - b.length());
        list.forEach(System.out::println);

    }

}
