package spring.aop;

import org.springframework.stereotype.Component;

public class player {

    public player() {}

    public String around(String arg){
        System.out.println("this is :" + arg);
        return arg;
    }

    public void say(){

        System.out.println("say hello ... ");

    }
}
