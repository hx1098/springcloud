package com.mashibing.zuultest.test1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/10 10:23
 * @description
 * @editUser hx
 * @editTime 2021/12/10 10:23
 * @editDescription
 *
 * 三目运算符中：第二个表达式和第三个表达式中如果都为基本数据类型，整个表达式的运算结果由容量高的决定。
 *
 * 99.9是double类型 而9是int类型，double容量高。
 *
 * byte shot int long double boolean char
 *  1    2    4   8     8             2
 */
public class test2 {

    public static void main(String args[ ]){

        int x=4;

        System.out.println("value is "+ ((x>4) ? 99.9 :9));


        //默认情况下, int 的初始值是0
        int[] y = new int[25];
        System.out.println(y[24]);




    }

}
