package com.example.demo.lambda.test;

import com.example.demo.lambda.Student;

/**
 * @author hx
 * @createTime 2021/9/21 9:35
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 9:35
 * @editDescription
 */
@FunctionalInterface
public interface InterfaceTest {

    /*只能有一个接口,的才叫函数式接口*/
    public void insert(Student student);

   /* public void sub();*/

}
