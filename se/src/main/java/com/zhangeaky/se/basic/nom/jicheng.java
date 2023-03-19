package com.zhangeaky.se.basic.nom;

/**
 * @Author: jiegege
 * @Date: 2021/12/17 11:49 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class jicheng {

    public static void main(String[] args) {
        B b = new B();
    }
}
class A {
    protected String name;
    A() {}
    A(String name) {
        this.name = name;
        System.out.println("Class A constructor calling ... ");
    }
}

class B extends A {

    B() {
        //super("nihao");
        System.out.println(super.name);
    }
}