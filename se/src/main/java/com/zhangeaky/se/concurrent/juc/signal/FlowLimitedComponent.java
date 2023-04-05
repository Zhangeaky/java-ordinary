package com.zhangeaky.se.concurrent.juc.signal;

import com.zhangeaky.se.bean.Person;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class FlowLimitedComponent <T, R> {

    private final List<T> pool;

    final Semaphore semaphore;

    FlowLimitedComponent(int size, T t) {
        pool = new Vector<T>(){};
        for (int i=0; i<size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }

    R exec(Function<T, R> func) {

        T t = null;

        try {
            semaphore.acquire();
        }catch (Exception e) {
            System.out.println(e);
        }

        try{
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("yida");
        person.setAge(20);
        FlowLimitedComponent<Person, String> component = new FlowLimitedComponent<>(10, person);

        component.exec(Person::getName);
    }
}
