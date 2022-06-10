package se.basic.nom;

/**
 * @Author: jiegege
 * @Date: 2021/12/17 3:23 下午
 * @address: hangzhou
 * @description:
 *      1. 类的private访问权限是 类本身 即该类的方法可以访问private 修饰的方法或成员变量
 *          包括静态函数,不同点在于静态函数需要实例化类对象才能对其private属性进行访问。
 *
 * @Version 1.0
 */
public class person {

    private int age = 18;

    private void shower() {
        System.out.println("I am taking a shower ... ");
    }

    public static void main(String[] args) {
        person pp = new person();
        int age = pp.age;
        pp.shower();
    }
}

class jorden {
    public int number = 23;
    public int getNumber() {
        return number;
    }
}

class newJordan extends jorden{
    public int number = 45;

    public int getNumber() {
        return number;
    }
}

class test {
    public static void main(String[] args) {
        newJordan nj = new newJordan();
        System.out.println(nj.getNumber());

        jorden jorden = new newJordan();
        System.out.println(jorden.getNumber());
    }

    private int[] a;
}






