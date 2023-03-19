package com.zhangeaky.se.bean;

/**
 * @Author: jiegege
 * @Date: 2022/3/20 7:41 PM
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class tmp {

    private String name;
    private String id;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "this is to String method "+"Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
