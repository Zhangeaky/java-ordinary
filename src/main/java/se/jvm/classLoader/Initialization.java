package se.jvm.classLoader;

/**
 * @Author: jiegege
 * @Date: 2022/1/4 9:54 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
interface GrandFather {
    static String name = "grandFather";
}


class Father implements GrandFather{
    static {
        System.out.println("Father 类的 类构造器执行 ... ");
        System.out.println(name);
    }
}



public class Initialization extends Father{

    private static int id = 888;

    static {
        System.out.println("类构造器执行 ... " + id);
    }

    static private String name = "zhangeaky";


    public static void main(String[] args) {

    }
}
