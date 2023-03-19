package com.zhangeaky.ee.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestBoot {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/spring/spring-service.xml");

        player bean = context.getBean(player.class);
        //com.zhangeaky.se.bean.say();
        bean.around("yida");

    }
}
