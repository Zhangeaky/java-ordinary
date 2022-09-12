package se.jvm.classLoader.initialization;

/**
 * @Author: jiegege
 * @Date: 2022/1/4 10:07 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class ConstClass {

    static {
        System.out.println("Const class initialization ... ");
    }

    static final String name = "HELLO_WORLD";
}
