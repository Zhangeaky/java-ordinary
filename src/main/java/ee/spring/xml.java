package ee.spring;

import ee.spring.aop.Service;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.bean.Person;
import se.bean.javabean.animal.Dog;

public class xml {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "META-INF/spring/spring-service.xml");

        context.refresh();

        Service bean = context.getBean(Service.class);
        bean.doService();



    }
}
