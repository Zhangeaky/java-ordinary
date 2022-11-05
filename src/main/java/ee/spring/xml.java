package ee.spring;

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
        Person bean = context.getBean(Person.class);
        System.out.println(bean.getDog());

        Dog myDog = context.getBean("myDog", Dog.class);
        System.out.println(myDog);

    }
}
