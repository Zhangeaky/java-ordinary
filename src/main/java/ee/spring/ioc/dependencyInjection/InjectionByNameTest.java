package ee.spring.ioc.dependencyInjection;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.bean.Person;

/**
 * 在xml中声明bean A 其依赖根据模式注解声明
 * 看这个bean A 是否会根据name 注入
 */
public class InjectionByNameTest {

    public static final String PATH = "classpath:/META-INF/ee/spring/spring-service.xml";

    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(PATH);

    public static void testByName() {

        context.refresh();
        Person bean = context.getBean(Person.class);
        System.out.println(bean);



    }

    public static void main(String[] args) {
        testByName();
    }
}
