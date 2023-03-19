package com.zhangeaky.se.reflection;

import com.zhangeaky.se.annotation.Zhangeaky;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 一、 反射机制的作用: 用于操作字节码文件,可以让程序更灵活。
 *  1. java反射相关的类
 *      java.lang.Class: 描述一个类的字节码文件
 *      java.lang.reflect.Method
 *      java.lang.reflect.Constructor: 所有的构造方法
 *      java.lang.reflect.Field: 对象的属性
 *      所有的Method Construct Field 包含在了Class 类中 用来描述以个类的Class文件的字节码
 *
 * 二、 三种获取class对象引用的方法
 *      静态函数
 *      class属性
 *      getClass方法
 *
 * 三、获取到Class对象 之后能干什么 反射创建对象实例
 *    Class.forName 方法执行的时候触发了类加载， 执行了类的静态代码块
 */

public class Practice01 {

    public static void readExternalProperties() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String path = "/Users/kimchang/IdeaProjects/javaSELearning/" +
                "src/SE/reflection/classinfo.properties";
        FileReader reader = new FileReader(path);

        Properties properties = new Properties();
        properties.load(reader);
        reader.close();
        String key = "className";
        String value = properties.getProperty(key);
        System.out.println(value);

        Class<?> classInstance = Class.forName(value);
        Object o = classInstance.newInstance();
        Object ob = classInstance.newInstance();
        System.out.println("class对象可以该类的对像实例，每调用一次就创建出一个新的对象: " + (o == ob));

    }

    public static void test() {
       // ClassLoader classLoader = new URLClassLoader();

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> a = contextClassLoader.loadClass("a");
            Class<ClassLoader> classLoaderClass = ClassLoader.class;


        } catch (Exception e) {

        }


    }

    public static void  test_annotation() {

        Class<? super Zhangeaky> superclass = Zhangeaky.class.getSuperclass();

        System.out.println(Zhangeaky.class);



    }

    public static void main(String[] args) throws ClassNotFoundException {

        //如何获取字节码文件的三种方式？
        // == 判断对象的哈希值
        // 1. Class.forName("~~~"); fully qualified name
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass);

        // 2. java 中任何一个对象都有一个getClass()方法 Objet实现
        String name = "zhangeaky";
        Class<? extends String> stringClass = name.getClass();
        System.out.println(stringClass);
        // 字节码class文件在jvm内存中只有一份
        System.out.println("统一个类型对象的字节码文件Class只有唯一一个实例： " + (stringClass == aClass));

        // 3. java Primitive type 都有一个class属性 代表其自己的类型
        Class<String> stringClass1 = String.class;
        System.out.println((stringClass1 == aClass));


        //newInstance() 调用无参构造

        Class<?> personClass = Class.forName("com.zhangeaky.se.bean.Person");
        try {
            Object person = personClass.newInstance();
            System.out.println(person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //验证反射机制的灵活性

        try {
            readExternalProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ClassForName的执行到底发生了什么？
        //静态代码块在类加载时执行，并且只执行一次, class.forname 会导致类加载
        //类加载时静态代码块执行
        Class.forName("com.zhangeaky.se.reflection.temp");

        System.out.println("===========");
        test_annotation();

    }
}

class temp {
    static {
        System.out.println("静态代码块的执行...");
    }
}
