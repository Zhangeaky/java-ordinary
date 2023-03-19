package com.zhangeaky.se.gof23.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 饿汉式
 */
public class IdGenerator {

    private final AtomicInteger id = new AtomicInteger(0);

    private IdGenerator() {}

    //饿汉式 直接在类加载的时候初始化生成单例对象
    //生成方式式线程安全的。
    private static final IdGenerator idGenerator = new IdGenerator();

    public static IdGenerator getInstance() {
        return idGenerator;
    }

    public int generateId() {
        return id.incrementAndGet();
    }
}
