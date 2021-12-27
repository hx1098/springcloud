package com.mashibing.zuultest.test1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/10 10:09
 * @description
 * @editUser hx
 * @editTime 2021/12/10 10:09
 * @editDescription
 */
public class B extends A{


    public B() {}
    @Override
    public int method1 (int a, int b) {
        return 0;
    }

    /**一个方法中可以有和构造方法相同的方法*/
    public void A() {
        System.out.println("A");
    }

}
