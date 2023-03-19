package com.zhangeaky.se.fanxing.method;

import com.zhangeaky.se.fanxing.bean.Bird;
import com.zhangeaky.se.fanxing.bean.Tiger;

public class GenericMethod {

    public static  <T, R> void input(T arg1, R arg2) {
        System.out.println(arg1.getClass().getCanonicalName() + '\n'
        + arg1.getClass().getCanonicalName());
    }

    public static void main(String[] args) {
        input(new Bird(), new Tiger());
    }
    
}
