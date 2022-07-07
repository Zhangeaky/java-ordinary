package se.enumlearning.enumDemo;

import java.util.Arrays;

/**
 * @Author: jiegege
 * @Date: 2022/2/20 2:48 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("I am from " + Country.PRC);

        System.out.println(Country.PRC.hashCode());
        System.out.println(Country.USA.hashCode());
        System.out.println(Country.UK.hashCode());

        System.out.println(Country.UK.getClass());
        System.out.println(Country.PRC.getClass());
        System.out.println(Country.USA.getClass());

        Country country = Country.UK;
        System.out.println("coutry 类型" + country.getClass());

        //Enum类的方法一
        System.out.println("Enum#name() " + country.name());
        //Enum类的方法二
        System.out.println("Enum#ordinal() " + country.ordinal());

        //枚举类的方法 values
        System.out.println(Arrays.toString(Country.values()));

        for (Country cc: Country.values()) {
            System.out.println(cc);

        }

        //外部包装类
        System.out.println(Country.PRC.getDeclaringClass());
        Country.main(new String[]{});


    }
}

/**
 * 枚举类不能被继承
 */
//class aaCountry extends Country{
//
//}
