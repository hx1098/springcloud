package com.example.demo.lambda;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.junit.Test;

import java.util.*;

/**
 * @author hx
 * @createTime 2021/9/20 17:19
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/20 17:19
 * @editDescription
 */
public class ListRemove {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {

            if ("1".equals(iterator.next())) {
                iterator.remove();
            }
            iterator.next();
        }
        list.forEach(System.out::println);
        System.out.println("===================");





    }

    @Test
    public void test1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("1".equals(next)) {
                iterator.remove();
            }
            //iterator.next();
        }
        list.forEach(System.out::print);




    }

    @Test
    public void test134(){
        Map<String, Integer> map = new HashMap<String, Integer>(16);
        map.put("zhangsan", 23);
        map.put("lisi", 34);
        map.put("26", 24);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();


    }
}
