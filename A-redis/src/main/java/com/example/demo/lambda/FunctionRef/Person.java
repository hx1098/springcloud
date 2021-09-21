package com.example.demo.lambda.FunctionRef;

import javax.naming.Name;

/**
 * @author hx
 * @createTime 2021/9/21 21:00
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/21 21:00
 * @editDescription
 */
public class Person {
    private String name;

    public static Person build(String name) {
        Person person = new Person();
        person.setName(name);
        return person;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
