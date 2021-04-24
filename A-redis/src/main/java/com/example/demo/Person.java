package com.example.demo;

/**
 * @author hx
 * @createTime 2021/2/17 14:23
 * @option
 * @description
 */
public class Person {

    /*private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/

    private String name; // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area; // 地区
    // 构造方法
    public Person(String name, int salary, int age,String sex,String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * salary
     *
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * salary
     *
     * @param salary salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * age
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * age
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * sex
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * sex
     *
     * @param sex sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * area
     *
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * area
     *
     * @param area area
     */
    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    // 省略了get和set，请自行添加
}
