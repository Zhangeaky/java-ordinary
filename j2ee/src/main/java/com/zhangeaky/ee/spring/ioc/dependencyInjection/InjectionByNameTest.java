package com.zhangeaky.ee.spring.ioc.dependencyInjection;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 在xml中声明bean A 其依赖根据模式注解声明
 * 看这个bean A 是否会根据name 注入
 */
public class InjectionByNameTest {

    public static final String PATH = "classpath:/META-INF/com.zhangeaky.ee.ee/spring/spring-service.xml";

    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(PATH);

    public static void testByName() {

        context.refresh();
    }

    public static void main(String[] args) {
        testByName();
    }
}
