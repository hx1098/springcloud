package com.mashibing.zuultest.test1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/10 10:33
 * @description
 * @editUser hx
 * @editTime 2021/12/10 10:33
 * @editDescription
 */
public class StringUtils {

    private void test() {
        String aStr = "?One?";
        String bStr = aStr;
        aStr.toUpperCase();
        System.out.println(aStr);
        aStr.trim();
        System.out.println(aStr);
        System.out.println("[" + aStr + "," + bStr + "]");
    }

    static public void main(String[] args) {
        new StringUtils().test();
    }


}
