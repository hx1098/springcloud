package com.example.demo.ShiftOperation;

import org.junit.Test;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/29 8:58
 * @option
 * @description 位移预算符号
 * @editUser hx
 * @editTime 2021/5/29 8:58
 * @editDescription
 */
public class ShiftOperation {

    public static void main(String[] args) {
        /*用于奇偶校验*/
        int a = 1;
        int b = 3;
        int c = 6;
        /*和1运算, 结果为1就是奇数*/
        System.out.println(a & b);
        /*和1运算, 结算为0就是偶数*/
        System.out.println(a & c);
    }

    @Test
    public void test1() {
        /*用于两个数的交换, 不使用第三个变量作为媒介*/
        int a = 1;
        int b = 3;
        /*预期结果: a = 3, b = 1;*/
        /*System.out.println(a ^ a ^ b);
        System.out.println(b ^ b ^ a);*/

        System.out.println(a^b);
        System.out.println(a^b^b);
        System.out.println(a^b^a);

        System.out.println(2);
        System.out.println(2^2);
        System.out.println(2^2^1);

        int i = 9;
        System.out.println(i);

        System.out.println(i^i);
        System.out.println(i^i^1);

    }

    @Test
    public void test3(){
        System.out.println(-128
        );
    }
}
