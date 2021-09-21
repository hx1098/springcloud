package com.example.demo.lambda.test;/**
 * @author yd
 * @date 2021/9/21 10:05
 * @version 1.0
 */

import com.example.demo.lambda.Teacher;

/**
 * @author hx
 * @createTime 2021/9/21 10:05
 * @option
 * @description
 */
@FunctionalInterface
public interface Teacherdao {

    public int insert(Teacher teacher);
}
