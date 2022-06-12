package se.reflection;


import bean.Person;

import java.lang.reflect.*;
import java.util.stream.Stream;

public class demo {

    public static final String LINE = "----------";

    public static Constructor constructor;


    public static void main(String[] args) throws Exception {

        Class integerClass = Integer.class;

        /**
         * 基础类型的class对象
         *
         * 基础类型的封装对象 包含了class 对象作为成员类型。
         *
         */
        Class intType = int.class;
        Class intPrimitive = Integer.TYPE;
        System.out.println("int 基础类型的Class, "+ (int.class == intPrimitive));

        Class clazz = Class.forName("bean.Person");

        System.out.println(LINE);
        /**
         * 获取公有的构造函数
         * Class#getConstructor()
         * Class#getConstructors()
         *
         */
        Constructor constructor = clazz.getConstructor();
        System.out.println("constructor:" + constructor);

        Constructor[] constructors = clazz.getConstructors();
        System.out.println("clazz.getConstructors() = " + Stream.of(constructors).count());

        Person tmpReflection = (Person)constructor.newInstance();

        Constructor targetConstructor = clazz.getDeclaredConstructor(String.class, Integer.TYPE);
        targetConstructor.setAccessible(true);
        Person zhangyikai = (Person)targetConstructor.newInstance("zhangyikai", 26);

        System.out.println("反射创建对象 " + zhangyikai);

        System.out.println(LINE);

        /**
         * 获取类的成员变量
         * - Constructor#getFields()
         * - 包括子类和父类的field
         * - 只能返回public
         */
        Field[] fields = clazz.getFields();
        /**
         * 返回当前类的所有属性
         */
        Field[] declaredFields = clazz.getDeclaredFields();
        //Modifier
        Stream.of(declaredFields).map(Field::getName)
                .forEach(System.out::println);

        /**
         * 使用反射更改属性的值 包括了更改属性的私有值
         * -
         *
         *
         */
        System.out.println("使用反射更改属性值");
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        Object o = clazz.newInstance();
        nameField.set(o, "zhangeaky");
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(o, 26);
        System.out.println(o);

        /**
         * 当前类及其父类的public方法
         *
         */

        Method[] methods = clazz.getMethods();
        Stream.of(methods).map(Method::getName)
                .forEach(System.out::println);
        System.out.println("getDeclared methods");

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Stream.of(declaredMethods).map(Method::getName).forEach(System.out::println);

        Object newone = clazz.newInstance();

        Method getName = clazz.getDeclaredMethod("getName");
        getName.invoke(newone);

        /**
         * 获取所有的构造函数，构造函数是不能继承的
         *
         * 反射创建对象 调用了无参构造函数
         */

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object o1 = declaredConstructor.newInstance();

        //Number


    }
}
