package se;

import io.vavr.control.Option;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OptionDemo {

    public static Map<String, String> handlerMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        handlerMap.put("hey", "yida");

        Option<String> hey = Option.of(handlerMap.get("hey")).map(input -> input+"world");

        System.out.println(hey);



    }
}
