package se.annotation;

import se.annotation.impl.AbilityImpl;

import java.lang.reflect.AnnotatedType;
import java.util.Objects;

@Zhangeaky(nickName = "tongshao")
@Constraints("fd")
public class TestDemo {


    public static void load() {

        AbilityImpl impl = new AbilityImpl();

        Zhangeaky annotation = impl.getClass().getAnnotation(Zhangeaky.class);
        System.out.println("ture: " + annotation);


    }

    /**
     * 测试 父类的field method上标注的注解能否在运行子类的反射上获取
     */
    public static void test01() {

        try {

            Class<?> clazz = Class.forName("se.annotation.impl.AbilityImpl");
            Zhangeaky testAnnotation = clazz.getMethod("testAnnotation").getAnnotation(Zhangeaky.class);
            System.out.println(testAnnotation);

            clazz.isAnnotationPresent(Zhangeaky.class);

        } catch (Exception e) {
            System.out.println(e);
        }



    }

    public static void main(String[] args) {

        test01();

    }
}
