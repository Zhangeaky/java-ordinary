package se.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author: jiegege
 * @Date: 2022/1/18 7:27 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */


public class SupplierDemo {

    void processString(String input) {

        System.out.println("I am processing " + input);

    }

    static void test(Supplier<?> input) {
        System.out.println("输入数据的为：" + input.get());
    }

    static void testConsumer(Consumer<String> consumer) {
        consumer.accept("a");
    }

    static  void testConsumer2 ( Consumer<String> consumer, String input) {
        consumer.accept(input);
    }


    public static void main(String[] args) {
        test(()->"james");
        testConsumer(System.out::println);
        testConsumer2(System.out::println, "nihao");
        SupplierDemo demo = new SupplierDemo();
        testConsumer(demo::processString);
    }

    static class innerTest {
        public static void main(String[] args) {
            Thread t = new Thread(()->{});
        }
    }




}
