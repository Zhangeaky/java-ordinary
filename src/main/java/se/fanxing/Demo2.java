package se.fanxing;

import se.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    public void reload(int b, String a) {

    }


    public String reload(String a, int b) {
        return null;
    }

    public void test(List<String> arg) {

    }

    /**
     * 无界通配符
     */
    private static void wildcard(List<?> input) {

        input.stream().forEach(System.out::println);
        input.stream().forEach(x-> System.out.println(x.getClass()));


    }

    public static void  test02() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Person());
        wildcard(persons);

        List<?> quer = persons;
        Object o = quer.get(0);



    }


    public static void main(String[] args) {

    }

}
