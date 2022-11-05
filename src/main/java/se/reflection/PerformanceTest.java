package se.reflection;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PerformanceTest {

    static class Man{
        public void say() {
            System.out.print("");
        }
    }

    public static void main(String[] args) throws Exception {

        int times =1000_0000_00;
        Class<?> manClass = Class.forName("se.reflection.PerformanceTest$Man");
        Method say = manClass.getMethod("say");

        Man man = new Man();
        test(times, (x)->{
            man.say();
        });

        say.invoke(man);
        test(times, (x)->{

            try {
                say.invoke(man);
            }
            catch (Exception e) {}
        });



    }

    public static void test(int x, Consumer<Integer> loop) {

        long l = System.currentTimeMillis();
        while (x>0) {
            loop.accept(x);
            x--;
        }
        loop.accept(x);
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end -l) + "ms");


    }
}
