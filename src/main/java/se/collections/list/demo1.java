package se.collections.list;

import se.javaBeans.person;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        person person = new person();
        person person1 = new person();

        List<person>  persons = new ArrayList<>();

        persons.add(person);
        persons.add(person1);
        persons.add(person);

        System.out.println(persons.size());


    }
}
