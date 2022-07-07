package jvm.classLoader;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author: jiegege
 * @Date: 2022/1/10 6:32 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class ClassLoaderDeepUnderStanding {

    static class hook {

        static void set(Object object) {
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        tool too = new tool();
        CustomizedClassLoader loader = new CustomizedClassLoader();

        System.out.println("CustomizedClassLoader 的 类加载器为 : " + loader.getClass().getClassLoader());
        //tool tool = (loader.loadClass("JVM.classLoader.tool"))loader.loadClass().newInstance();
        Class<?> aClass = loader.loadClass("jvm.classLoader.tool");
        Object o = aClass.newInstance();
        System.out.println(o.getClass().getClassLoader());

        Class<? extends tool> aClass1 = too.getClass();
        System.out.println(aClass);

        System.out.println(aClass.equals(aClass1));


    }

    static class myClassLoader extends URLClassLoader {

        public myClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }
    }

    static class test {
        public static void main(String[] args) throws ClassNotFoundException {

            ClassLoader classLoader = ClassLoaderDeepUnderStanding.class.getClassLoader();
            Class<?> aClass = classLoader.loadClass("jvm.garbage.FinalizeEscape");
            Method[] declaredMethods = aClass.getDeclaredMethods();

            for (Method method:declaredMethods) {
                System.out.println(method);
            }
        }
    }

    static class ClassLoaderTestDemo {
        public static void main(String[] args) throws ClassNotFoundException {
            Thread.currentThread().getContextClassLoader().loadClass("java.lang.String");
        }

    }

    static  class para {
        public static void main(String[] args) {

        }
    }
}
