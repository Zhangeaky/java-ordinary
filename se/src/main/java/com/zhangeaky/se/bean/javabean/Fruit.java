package com.zhangeaky.se.bean.javabean;

public class Fruit {

    String name;
    String flavor;
    String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", flavor='" + flavor + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
