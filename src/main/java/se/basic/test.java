package se.basic;
//import SE.basic.accessibility.classCollection.

import se.bean.Person;

/**
 * @Author: jiegege
 * @Date: 2022/2/13 11:08 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {

        Person p  =new Person();
        p.setAge(10);
        Integer age = p.getAge();
        System.out.println(p);
        System.out.println(p);
        PackageInner.say();
        ByteDemo.test_package();



    }
}
