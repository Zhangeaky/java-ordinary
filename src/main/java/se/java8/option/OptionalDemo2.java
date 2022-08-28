package se.java8.option;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Predicate;

public class OptionalDemo2 {

    public static int readDuration(Properties properties, String name) {

        Object o = Optional.ofNullable(properties.get(name))
                .orElse(0);
        return 0;
    }

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "true");
        properties.setProperty("c", "-3");


    }
}
