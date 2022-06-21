package se.collections.list;

import com.google.common.collect.Lists;
import se.javaBeans.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo1 {


    private static List<String> lists = Arrays.asList("a", "yida", "zhangyikai");


    private static void sublistDemo() {

        List<String> strings = lists.subList(0, 1);
        strings.forEach(System.out::println);
        System.out.println("[className]: " + strings.getClass());

        ArrayList<String> newList = new ArrayList<String>(){{
            add("b");
            add("a");
        }};

        //Lists.newArrayList()


    }

    public static void main(String[] args) {
//        person person = new person();
//        person person1 = new person();
//
//        List<person>  persons = new ArrayList<>();
//
//        persons.add(person);
//        persons.add(person1);
//        persons.add(person);
//
//        System.out.println(persons.size());

        sublistDemo();

    }
}
