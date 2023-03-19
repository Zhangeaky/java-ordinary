package com.zhangeaky.se.juc.containers;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactory {

    public static ConcurrentHashMap<String, Integer> serviceMap1 = new ConcurrentHashMap<>(16);

    public static HashMap<String, Integer> serviceMap2 = new HashMap<>(16);

}
