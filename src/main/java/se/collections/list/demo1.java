package se.collections.list;

import se.bean.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class demo1 {

    private static ArrayList<String> persons = new ArrayList<>();

    private static LinkedList<String> teams = new LinkedList<>();


    static {
        persons.add("zhangyikai");
        persons.add("kobe");
        persons.add("jar");

        teams.add("rockets");
        teams.add("76ers");
        teams.add("lakers");
    }



    private static List<String> lists = Arrays.asList("a", "yida", "zhangyikai");

    private static String[] strings = {"zhangyikai", "yinghaozhe", "wangben"};



    private static void genericArrayListDemo() {

        List<Person> people = Arrays.<Person>asList(new Person(), new Person());

        //使用 Arrays.toString 生成数组的可打印形式
        System.out.println(strings);
        System.out.println(Arrays.toString(strings));

        persons.add(2, "Gordon");
        System.out.println(persons);
        persons.add(3, "Paul");
        System.out.println(persons);

        teams.add(0, "caveliers");
        System.out.println(teams);

        int caveliers = teams.indexOf(new String("newcaveliers"));
        System.out.println("index of: " + caveliers);

        System.out.println(Integer.valueOf(4).byteValue());


    }

    private static void sublistDemo() {

        List<String> strings = lists.subList(0, 1);
        strings.forEach(System.out::println);
        System.out.println("[className]: " + strings.getClass());

        ArrayList<String> newList = new ArrayList<String>(){{
            add("b");
            add("a");
        }};




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

        //sublistDemo();

        genericArrayListDemo();

    }
}
