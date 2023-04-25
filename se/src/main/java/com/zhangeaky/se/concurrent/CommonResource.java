package com.zhangeaky.se.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public interface CommonResource {

    ThreadPoolExecutor es = new ThreadPoolExecutor(100, 200, 20,
        TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),  Executors.defaultThreadFactory(),
        new ThreadPoolExecutor.CallerRunsPolicy() );

}
