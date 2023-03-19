package com.zhangeaky.ee.spring.aop;

public class player {

    public player() {}

    private String go() {
        System.out.println("私有方法");
        return "";
    }

    public String around(String arg){
        go();
        System.out.println("this is :" + arg);
        return arg;
    }

    public void say(){

        System.out.println("say hello ... ");

    }
}
