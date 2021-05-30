package com.example.demo.lambda;

import com.example.demo.Person;
import com.sun.org.apache.xpath.internal.functions.FuncExtFunction;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hx
 * @createTime 2021/4/24 19:12
 * @option
 * @description  stream 流的例子
 */
public class javaStream {

    public List<Person> initData(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Jack", 7000, 34,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 23,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 20,"female", "New York"));
        personList.add(new Person("Owen", 9500, 27,"male", "New York"));
        personList.add(new Person("Alisa", 7900,56, "female", "New York"));
        return personList;
    }


    public static void main(String[] args) {

//        1、通过 java.util.Collection.stream() 方法用集合创建流
        List<String> list = Arrays.asList("a","b","c","d");
//        顺序流
        Stream<String> stream = list.stream();
//        并行流
        Stream<String> stringStream = list.parallelStream();


//        2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] arr = {1,2,3,4,5,6};
        IntStream stream1 = Arrays.stream(arr);




    }

    @Test
    public void test1(){
//        3、使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> integerStream = Stream.of(1, 4, 5, 6, 7);
        integerStream.forEach(System.out::print);

        System.out.println();
        Stream<Integer> limit = Stream.iterate(0, x -> x + 3).limit(4);
        limit.forEach(System.out::print);

        System.out.println();
        Stream<Double> limit1 = Stream.generate(Math::random).limit(3);
        limit1.forEach(x->{
            System.out.print(x +",");
        });

    }





//    3.1 遍历/匹配（foreach/find/match）

    @Test
    public void test4(){
        List<Integer> integers = Arrays.asList(6, 7, 2, 5, 7, 2, 7, 2);
//        输出所有的大于6 的数据
        integers.stream().filter(x->x >6).forEach(System.out::print);

        Optional<Integer> first = integers.stream().filter(x -> x > 6).findFirst();
        System.err.println("匹配第一个值:" + first);

        Optional<Integer> any = integers.stream().filter(x -> x > 6).findAny();
        System.err.println("匹配任意一个: " + any);

        boolean b = integers.stream().anyMatch(x -> x > 6);
        System.err.println("是否存在大于6的值: " + b);
    }




//    3.2 筛选（filter）
    @Test
    public void test12(){
        List<Integer> list = Arrays.asList(5, 7, 9, 1, 4, 8, 4, 7);
        Stream<Integer> stream = list.stream();
        stream.filter(x->x>7).forEach(System.out::print);


    }

    @Test
    public void test2(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Jack", 7000, 34,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 23,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 20,"female", "New York"));
        personList.add(new Person("Owen", 9500, 27,"male", "New York"));
        personList.add(new Person("Alisa", 7900,56, "female", "New York"));

        //获取员工工资大于8000的
        List<Person> collect = personList.stream().filter(x -> x.getSalary() > 8000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        //获取员工工资大于8000的名字
        List<String> collect1 = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect1);



    }

//    3.3 聚合（max/min/count)
    @Test
    public void test13(){
        List<String> strings = Arrays.asList("admin", "pot", "zhangsan", "lisi");

        Optional<String> max = strings.stream().max(Comparator.comparing(String::length));
        System.out.println("最长字符串: " + max);
    }

    @Test
    public void test5(){
        List<Integer> list = Arrays.asList(4, 5, 7, 1, 2, 6, 8, 9, 6);

        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.err.println("自然排序最大值: " + max);

        Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.err.println("自定义排序最大值: " +max1.get());
    }



    @Test
    public void test6() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Jack", 7000, 34, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 23, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 20, "female", "New York"));
        personList.add(new Person("Owen", 9500, 27, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 56, "female", "New York"));

        //获取员工工资大最高的人
        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最高的人是: " + max);


        List<Integer> list = Arrays.asList(7, 4, 8, 9, 0, 2, 3);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list 中大于6的个数是: " + count);

    }



//    3.4 映射(map/flatMap)
//    map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
//    flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。

    @Test
    public void test20(){
        String[] str = {"sre","weiru","ouo","wert"};

        List<String> strings = Arrays.asList(str);
        List<String> collect = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写: " +collect);

        Integer[] integers = {1,4,6,7};
        List<Integer> ints = Arrays.asList(integers);
        List<Integer> collect1 = ints.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("每个元素加三 : "+ collect1);


//        将每个人的工资都加上1000
        List<Person> people = initData();
        System.out.println("加工资前: ");
        people.forEach(x->{
            System.err.println(x.getName() +"--->" +x.getSalary());
        });

        List<Person> collect2 = people.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 1000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("不改变原来集合的方式: :加工资之后: " );
        collect2.forEach(x->{
            System.err.println(x);
        });


        List<Person> collect3 = people.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("改变原来集合的方式: :加工资之后: " );
        collect3.forEach(x->{
            System.err.println(x);
        });


    }


//案例三：将两个字符数组合并成一个新的字符数组。
    @Test
    public void test30(){
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println("处理前:" + list);
        System.out.println("处理后: " + collect);
    }



//    3.5 归约(reduce)
//    归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。

    @Test
    public void test16() {
        List<Integer> list = Arrays.asList(1, 2, 4, 7, 3, 6);

//        求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        System.out.println("list求和：" + sum.get());

//        求和方式二
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println("reduce list求和" + reduce);

//        求和方式三
        Integer reduce1 = list.stream().reduce(0, Integer::sum);
        System.out.println("reduce list求和" + reduce1);


//        求乘积
        Optional<Integer> reduce2 = list.stream().reduce((x, y) -> x * y);
        System.out.println(reduce2);


//        求最大值
        Optional<Integer> reduce3 = list.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println(reduce3);
//        求最大值
        Integer reduce4 = list.stream().reduce(0, Integer::max);
        System.out.println(reduce4);

        //https://gitee.com/hx1098/spring-cloud-config.git

    }


    @Test
    public void test33(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));

        Map<String, Integer> collect = personList.stream().collect(Collectors.toMap(Person::getName, Person::getAge));



    }





}
