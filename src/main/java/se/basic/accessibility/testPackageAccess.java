package se.basic.accessibility;

/**
 * @Author: jiegege
 * @Date: 2022/2/13 11:12 下午
 * @address: hangzhou
 * @description:  编译单元内 没有public修饰的类 只能在包内(package)被访问。 在包外无法被访问。
 * @Version 1.0
 */
public class testPackageAccess {

    public static void main(String[] args) {
        new one();
        new tow();
    }
}
