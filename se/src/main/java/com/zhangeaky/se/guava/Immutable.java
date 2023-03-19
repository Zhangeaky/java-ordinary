package com.zhangeaky.se.guava;

import com.google.common.collect.ImmutableMap;
import com.zhangeaky.se.bean.Person;

import java.util.HashMap;
import java.util.Map;

public class Immutable {

    public static void main(String[] args) {

        Map<String, Person> contacts = new HashMap<>();
        contacts.put("yida", new Person("yida", 18));
        contacts.put("tongshao", new Person("tongshao", 30));

        ImmutableMap<String, Person> immutable = ImmutableMap.copyOf(contacts);

        System.out.println(contacts.equals(immutable));
        System.out.println("hashCode of original :" + contacts.hashCode());
        System.out.println("hashCode of imm:" + immutable.hashCode());

        System.out.println("===change===");
        contacts.get("yida").setAge(26);

        System.out.println(immutable);


    }
}
