package se.thread.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalDemo {



    public static void main(String[] args) {

        ThreadLocal<Map<String, String>> context = new ThreadLocal<>();
        context.set(new HashMap<String, String>());

        //ThreadLocalRandom threadLocalRandom = new ThreadL
    }
}
