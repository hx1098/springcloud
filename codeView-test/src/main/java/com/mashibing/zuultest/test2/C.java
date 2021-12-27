package com.mashibing.zuultest.test2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/10 13:44
 * @description
 * @editUser hx
 * @editTime 2021/12/10 13:44
 * @editDescription
 */
public class C {

    public static void main(String[] args) {

        Object obj = new Object() {

            public int hashCode() {

                return 42;

            }

        };

        System.out.println(obj.hashCode());

    }

}
