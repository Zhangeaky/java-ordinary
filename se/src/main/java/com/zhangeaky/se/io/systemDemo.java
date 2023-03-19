package com.zhangeaky.se.io;

import java.util.Properties;

public class systemDemo {

    public static void main(String[] args) {

        Properties properties = System.getProperties();
        System.out.println(properties.size());
        for (Object o : properties.keySet()) {
            System.out.println("" + o + "=" + properties.get(o));
        }

    }
}
