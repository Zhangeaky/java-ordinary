package se.fanxing.method;

import se.fanxing.bean.Animal;
import se.fanxing.bean.Bird;
import se.fanxing.bean.Tiger;

public class GenericMethod {

    public static  <T, R> void input(T arg1, R arg2) {
        System.out.println(arg1.getClass().getCanonicalName() + '\n'
        + arg1.getClass().getCanonicalName());
    }

    public static void main(String[] args) {
        input(new Bird(), new Tiger());
    }
    
}
