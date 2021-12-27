package com.mashibing.zuultest.test1;

import org.junit.Test;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/10 10:18
 * @description
 * @editUser hx
 * @editTime 2021/12/10 10:18
 * @editDescription
 * 执行顺序:
 *  x = 10
 *  x = 10+5 = 15
 *  x= 15/3 = 5
 *  最后输出5
 *
 */
public class StaticStuff {

    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String args[]) {
        System.out.println("x =" + x);
    }
    static {
        System.out.println( x);
        x /= 3;
        System.out.println(x);
    }

    @Test
    public void test1(){

    }

}
