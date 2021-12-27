package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/27 10:13
 * @description
 * @editUser hx
 * @editTime 2021/12/27 10:13
 * @editDescription  定义一个元注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnnotation {


}
