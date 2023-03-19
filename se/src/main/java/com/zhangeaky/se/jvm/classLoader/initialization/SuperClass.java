package com.zhangeaky.se.jvm.classLoader.initialization;

/**
 * @Author: jiegege
 * @Date: 2022/1/4 9:55 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class SuperClass {
    static {
        System.out.println("Super class init!");
    }

    static final int id = 10;

    SuperClass() {
        System.out.println("构造函数调用... ");
    }

    public static void main(String[] args) {

        int a = id;

    }
}
