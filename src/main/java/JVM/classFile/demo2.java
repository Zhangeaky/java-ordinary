package JVM.classFile;

/**
 * @Author: jiegege
 * @Date: 2021/12/27 11:18 PM
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class demo2 implements Cloneable{

    private int a = 10;
    private char b = 'a';
    private boolean flag = false;

    public void func() {
        int i = 8;
        i = i++;
    }

    public static void test() {

        System.out.println(System.getProperty("java.class.path"));
    }

    public static void main(String[] args) {

        ClassLoader classLoader = demo2.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(Thread.currentThread().getContextClassLoader() == classLoader);
    }
}
