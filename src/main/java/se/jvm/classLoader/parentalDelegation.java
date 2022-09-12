package se.jvm.classLoader;

/**
 * @Author: jiegege
 * @Date: 2022/2/20 11:00 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class parentalDelegation {

    public static void disPlay(String content) {

        System.out.println(content);

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Thread thread = Thread.currentThread();

        CustomizedClassLoader myClassLoader = new CustomizedClassLoader();

        Class<?> newString = myClassLoader.loadClass("java.lang.String");

        Object o = newString.newInstance();
        System.out.println(newString.getClassLoader());

        thread.setContextClassLoader(myClassLoader);
        System.out.println(thread.getContextClassLoader());
    }
}
