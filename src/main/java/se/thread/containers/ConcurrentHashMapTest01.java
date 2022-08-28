package se.thread.containers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import se.thread.containers.ServiceFactory;

public class ConcurrentHashMapTest01 {

    ThreadLocal a;

    public static void main(String[] args) {

        int i = ThreadLocalRandom.current().nextInt(3);
        System.out.println(i);

        List<String> collect = IntStream.rangeClosed(1, 3).mapToObj(x -> "item" + ThreadLocalRandom.current().nextInt(3))
                .collect(Collectors.toList());
        System.out.println(collect);


        // test01();
    }

    public static void test01() {
        System.out.println("test");

        ForkJoinPool pool = new ForkJoinPool(5);

        pool.execute(()->{
            System.out.println("[worker thread name is] " + Thread.currentThread().getName());
            for (int i=0; i<10; i++) {
                ServiceFactory.serviceMap2.put(String.valueOf(i), i);

            }
        });

        pool.execute(()->{
            System.out.println("[worker thread name is] " + Thread.currentThread().getName());

            for (Map.Entry<String, Integer> element: ServiceFactory.serviceMap2.entrySet()) {
                if (Integer.parseInt(element.getKey()) % 2 == 0) {
                    ServiceFactory.serviceMap2.put(element.getKey(), element.getValue()*2);
                }
            }
        });


        try {
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(ServiceFactory.serviceMap2);

    }

    public static void testPutIfPresent() {
        HashMap<String, Integer> serviceMap2 = ServiceFactory.serviceMap2;

        serviceMap2.computeIfAbsent("name", Integer::valueOf);

    }
}
