package com.example.demo.lambda.FunctionRef;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/21 15:27
 * @description
 * @editUser hx
 * @editTime 2021/9/21 15:27
 * @editDescription
 */
public class Test6_lambda {


    /*通过数组来生成*/
    public static void get() {
        String[] arr = {"a", "y", "y", "o", "p"};
        Stream<String> arr1 = Stream.of(arr);
        arr1.forEach(System.out::println);
    }

    /*通过集合来生成*/
    public static void getList() {
        List<String> list = Arrays.asList("wer", "lisi", "wangwu", "zhaoliu");
        Stream<List<String>> list1 = Stream.of(list);
        list1.forEach(System.out::println);

    }

    //这里的数据要限制一下, 否则他会一直打印
    public static void generate() {
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(100).forEach(System.out::println);
    }

    //使用iterator
    public static void iterator() {
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }

    //使用其他方式
    public static void others() {
        String str = "dsuhifuisd";
        IntStream chars = str.chars();
        Stream<IntStream> chars1 = Stream.of(chars);
        chars.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //get();
        //getList();
        //generate();
        //iterator();
        others();

        //中间操作

        System.out.println("=========求出偶数=============");
        List<Integer> collect = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("=========求出偶数=============");
        long count = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(count);


        System.out.println("============求出最大值=============");
        List<Integer> list = Arrays.asList(1, 3, 4, 6, 7, 9);
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max);
        System.out.println("=================求除最小值==================");
        //埠省略
        Optional<Integer> min1 = list.stream().min((a, b) -> {
            return a - b;
        });
        Optional<Integer> min = list.stream().min((a, b) -> a - b);
        System.out.println(min.get());

        System.out.println("=========找出第一个后就终止的操作=========");
        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());

        System.out.println("======================");
        //获取到第一个就终止
        Optional<Integer> first = list.stream().filter(x -> x % 2 == 0).findFirst();
        System.out.println(first.get());

        //获取最大值, 最小值
        System.out.println("=======================");
        Optional<Integer> first1 = list.stream().sorted().findFirst();
        System.out.println(first1.get());
        Optional<Integer> max1 = list.stream().sorted().max((a, b) -> b - a);
        System.out.println(max1.get());


        Arrays.asList("java", "C#", "scala", "net").stream().sorted().forEach(System.out::println);
        System.out.println("--------------");
        Arrays.asList("java", "C#", "scala", "net").stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);


        System.out.println("===========将集合中的元素进行过滤同时返回一个集合对象===============");
        //    将集合中的元素进行过滤同时返回一个集合对象
        List<Integer> collect1 = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect1.forEach(System.out::println);
        System.out.println("------------");

        System.out.println("============去重复的操作..==========");
        List<Integer> list1 = Arrays.asList(1, 2, 2, 24, 5, 6, 6, 6, 7, 7);
        list1.stream().distinct().forEach(System.out::println);

        System.out.println("-------------");
        list1.stream().collect(Collectors.toSet()).forEach(System.out::println);



        System.out.println("==============打印20~30这样的数据=================");
        Stream.iterate(1,x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);


        System.out.println("=================求出数据之和==============");
        String strings = "1,2,3,4,5,7";
        int sum = Stream.of(strings.split(",")).mapToInt(e -> Integer.valueOf(e)).sum();
        System.out.println(sum);
        System.out.println(Stream.of(strings.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());

        System.out.println(Stream.of(strings.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(strings.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());


        System.out.println("=================多个集合整体创建==================");
        String string4 = "java,scala,c#";
        Stream.of(string4.split(",")).map(x -> new Person(x)).forEach(System.out::println);
        Stream.of(string4.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(string4.split(",")).map(Person::build).forEach(System.out::println);


        System.out.println("===================求和并打印出每一个数据=============");
        String string5 = "1,2,3,4,5";
        System.out.println(Stream.of(string5.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());




    }


}
