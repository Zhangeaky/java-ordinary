package com.zhangeaky.se.reflection;

import com.zhangeaky.se.bean.javabean.Fruit;
import com.zhangeaky.se.fanxing.AbstractUser;
import com.zhangeaky.se.fanxing.User;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.ProtectionDomain;
import java.util.Optional;
import java.util.stream.Stream;

public class Practice04 extends AbstractUser<Integer>  {

    @Override
    public Object say(Object input) {
        return null;
    }

    @Override
    public Integer walk() {
        return 100;
    }

    public static void testString() {

        Fruit fruit = new Fruit();

        fruit.setOrigin("US");
        System.out.println(fruit);

        Optional.ofNullable(fruit.getClass())
                .ifPresent((x)->{

                    try {
                        Field origin = x.getDeclaredField("origin");
                        origin.setAccessible(true);
                        origin.set(fruit, "CHINA");
                    } catch (Exception e) {
                        e.printStackTrace();//不要这么做
                    }

                });
        System.out.println(fruit);


    }

    public static void  test() throws Exception{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        Class clazz = null;
        try {
            clazz = loader.loadClass("com.zhangeaky.se.bean.javabean.Fruit");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(clazz);
        Fruit fruit = Optional.ofNullable(clazz)
                .map(x -> {
                    Fruit ff = null;
                    try {
                        ff = (Fruit) x.getConstructor().newInstance();
                        System.out.println("ff" + ff);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    return ff;
                }).orElse(null);
        fruit.setName("Apple");
        fruit.setFlavor("Sweet");
        fruit.setOrigin("xinjiaong");
        System.out.println("Fruit" + fruit);

    }

    public static void test_array() {
        int[] numbers = new int[10];
        System.out.println(numbers.getClass());

        System.out.println(int.class.isPrimitive());
        System.out.println(double.class.isLocalClass());
        System.out.println(Practice04.class.isLocalClass());
        Class a = void.class;
        Class b = Void.class;
        System.out.println("a: " + a + " " + "b: " + b);

    }

    public static void  test_obj() {
        System.out.println(Object.class.equals(Practice04.class));
    }

    public static void test_package() {

        Class<?> clazz = Practice04.class;
        Package aPackage = Practice04.class.getPackage();
        String name = aPackage.getName();

        ProtectionDomain protectionDomain = clazz.getProtectionDomain();


        System.out.println("Package: " + aPackage);
        System.out.println("name: " + name);
        System.out.println("protectionDomain: " + protectionDomain);
        System.out.println("protectionDomain#codeSource: " + protectionDomain.getCodeSource());
        System.out.println("protectionDomain#codeSource#location:  " + protectionDomain.getCodeSource().getLocation());
        System.out.println("protectionDomain#codeSource#location#path:  " + protectionDomain.getCodeSource().getLocation().getPath());

    }

    public static void test_generic() {

        Class clazz =  Practice04.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        Type[] genericInterfaces = clazz.getGenericInterfaces();

        System.out.println(User.class);
        Stream.of(genericInterfaces).forEach(System.out::println);

        System.out.println("GenericSuperClass: " + genericSuperclass.getClass());




    }



    public static void main(String[] args) throws Exception{
        //test();
        //testString();
        //test_array();
        //test_package();

        test_generic();
    }
}
