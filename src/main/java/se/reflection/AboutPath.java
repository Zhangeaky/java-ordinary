package se.reflection;

import java.util.ResourceBundle;

/**
 * 一、利用classpath来获取一个文件的绝对路径
 *  什么是类路径？
 *  凡是在src下的文件就是在类路径中 类的根路径
 *
 * 二、ResourceBundle
 *  只能绑定以 .properties 为尾缀的文件
 *  且文件必须在类路径下
 *  参数是文件名 不带文件后缀
 *
 */
public class AboutPath {

    public static void main(String[] args) {

        /**
         * currentThread() 当前线程
         * getContextClassLoader() 当前线程的类加载器
         * getResource() 默认从类的根路径下加载资源
         *
         * */
        String path = Thread.currentThread().getContextClassLoader().getResource("example.properties").getPath();
        System.out.println(path);
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader().getResourceAsStream("example.properties"));


        ResourceBundle resourceBundle = ResourceBundle.getBundle("example");
        System.out.println("Bundle type: " + resourceBundle.getClass());
        String string = resourceBundle.getString("user");
        System.out.println(string);

        ResourceBundle bundle = ResourceBundle.getBundle("se/reflection/classinfo");
        String className = bundle.getString("className");
        System.out.println(className);


        //A a = new A();

    }
}
