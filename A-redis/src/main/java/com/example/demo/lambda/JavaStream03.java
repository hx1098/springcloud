package com.example.demo.lambda;

import org.junit.Test;
import org.springframework.boot.env.YamlPropertySourceLoader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/25 22:32
 * @option
 * @description
 */
public class JavaStream03 {



     static class Person{
        private String name; // 姓名
        private int salary; // 薪资
        private int age; // 年龄
        private String sex; //性别
        private String area; // 地区
        public Person(String name, int salary, int age,String sex,String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public int getSalary() {
             return salary;
         }

         public void setSalary(int salary) {
             this.salary = salary;
         }

         public int getAge() {
             return age;
         }

         public void setAge(int age) {
             this.age = age;
         }

         public String getSex() {
             return sex;
         }

         public void setSex(String sex) {
             this.sex = sex;
         }

         public String getArea() {
             return area;
         }

         public void setArea(String area) {
             this.area = area;
         }
     }



    @Test
    public void test1(){
        List<String> list = Arrays.asList("1", "2", "3");
       /* //创建一个顺序流
        list.stream();

        //闯将一个并行流
        list.parallelStream();

        //使用Stream的静态方法
        Stream<Integer> stream = Stream.of(1, 3, 4, 6, 8);
*/
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        //stream2.forEach(System.out::print);//输出： 0369


        //输出三个随及的double的小数
        Stream<Double> stream4 = Stream.generate(Math::random).limit(3);
        //stream4.forEach(System.out::print);


        //还可以将java的顺序流转换为并行流
        //Optional是一个可以为null的容器对象,如果值存在的则isPresent()方法返回为true ,调用get()方法返回该对象
        List<Integer> list1 = Arrays.asList(12, 2, 4, 56, 3);
        Optional<Integer> first = list1.stream().parallel().filter(x -> x > 6).findFirst();




    }

   @Test
   public void test2(){
       // 筛选出值大于7 的值
       List<Integer> list = Arrays.asList(1, 4, 5, 7, 9);
       //list.stream().filter(x->x>3).forEach(System.out::println);


       List<Person> personList = new ArrayList<Person>();
       personList.add(new Person("Tom", 8900, 23, "male", "New York"));
       personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
       personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
       personList.add(new Person("Anni", 8200, 24, "female", "New York"));
       personList.add(new Person("Owen", 9500, 25, "male", "New York"));
       personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

       List<Person> collect = personList.stream().filter(x -> x.salary > 8000).collect(Collectors.toList());
       List<String> collect1 = personList.stream().filter(x -> x.salary > 8000).map(Person::getName).collect(Collectors.toList());
       collect1.forEach(s -> {
           System.out.println(s);
       });


   }



    @Test
    public void test3(){
        // 筛选出值大于7 的值
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Collections.sort(list,(a,b)->a.length()-b.length());
        list.forEach(System.out::println);

        Optional<String> max = list.stream().max(Comparator.comparing(String::length));

    }

    @Test
    public void test34(){
        Collection collections = new ArrayList<String>();
        Collection collections2 = new ArrayList<String>();
        collections.add("1");
        collections.add("2");
        collections2.add("string");
        System.out.println(collections.retainAll(collections2));
    }


    @Test
    public void test345(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("123");
        linkedList.add("456");
        linkedList.add("789");
      /*  System.out.println(linkedList.peek());
        System.out.println("========================");
*/
      /*  linkedList.forEach(System.out::println);

        System.out.println("========================");
        System.out.println(linkedList.poll());
        linkedList.forEach(System.out::println);*/

        System.out.println("========================");
        System.out.println(linkedList.pop());
        //linkedList.forEach(System.out::println);
    }






}
