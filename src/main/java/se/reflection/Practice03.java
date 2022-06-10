package se.reflection;

import bean.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author: jiegege
 * @Date: 2021/12/18 12:33 上午
 * @address: hangzhou
 * @description:
 *  获取field属性
 *
 * @Version 1.0
 */
public class Practice03 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getType().getSimpleName());
        }


        System.out.println(Modifier.toString(1));


    }

}
