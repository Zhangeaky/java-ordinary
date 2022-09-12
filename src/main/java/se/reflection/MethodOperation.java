package se.reflection;

import se.bean.Person;

import java.lang.reflect.Method;

public class MethodOperation {

    public static void main(String[] args) {

        Person person = new Person();
        person.say("Before");

        try {

            Class<?> clazz = Class.forName("se.bean.Person");

            Method say = clazz.getMethod("say", String.class);

            say.invoke(person, "ffff");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
