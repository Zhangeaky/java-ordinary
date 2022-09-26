package se.bean;

import se.reflection.bean.AbstractPerson;

import java.util.Objects;

public class Person extends AbstractPerson {

    private String name = "zhang";
    private Integer age = 18;

    public Person(String test) {
        System.out.println("test construct， 公有有参构造函数");
    }

    public Person() {
        System.out.println("公有无参构造方法...");
    }

    private Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public static Person newInstance(String name, int age) {
        return new Person(name, age);
    }

    public void say(String input) {
        System.out.println("公有函数 say(), 参数输出:" + input);
    }

    private void yell(String input) {
        System.out.println("私有函数 yell(), 参数输出:" + input);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getAge().equals(person.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}