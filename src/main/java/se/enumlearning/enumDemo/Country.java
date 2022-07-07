package se.enumlearning.enumDemo;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.Currency;

/**
 * @Author: jiegege
 * @Date: 2022/2/20 2:47 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public enum Country {

    USA("",""),
    PRC("",""),
    UK("",""),
    JPA("",""),
    CAN("",""),
    BRA("","");

    private String name;
    private String currency;

    Country(String name, String currency){
        this.name=name;
        this.currency=currency;
    }

    /**
     * 在每个枚举类中定义了方法，枚举实例就会有
     */
    public void sayHello() {
        System.out.println(name());
    }

    public static void main(String[] args) {
        Country.values()[0].sayHello();
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }
}
