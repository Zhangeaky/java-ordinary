package se.effectivejava;

import se.bean.javabean.Apple;
import se.bean.javabean.Fruit;
import se.bean.javabean.animal.Dog;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectsNonFinalMethodsDemo {


    static void test01() {

        Map<String, Dog> dogs = new HashMap<>();
        Dog dd = new Dog();
        dd.setType("00");
        dd.setName("fd");
        dogs.put("01", dd );
        System.out.println(dogs.containsValue(dd));
        dd.setName("fdfd");
        System.out.println(dogs.containsValue(dd));

        Objects.requireNonNull(" ");



    }





    static void test02() {

        String a = "a";
        a = "a" + "a";



    }



    public static void main(String[] args) {
        
        String[] aa = new String[10];
        String[] clone = aa.clone();




        Apple apple = new Apple("", new BigDecimal(1));
        Fruit fruit = new Fruit();

        boolean b = apple instanceof Fruit;
        System.out.println(b);

        System.out.println("----------");
        test01();



    }
}
