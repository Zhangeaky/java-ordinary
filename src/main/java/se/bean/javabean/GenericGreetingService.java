package se.bean.javabean;

import se.bean.GreetingService;

public class GenericGreetingService implements GreetingService {

    @Override
    public void greet(String name) {
        System.out.println(name + "我为您服务");
    }
}