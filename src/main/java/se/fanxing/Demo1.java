package se.fanxing;

import se.fanxing.bean.Animal;
import se.fanxing.bean.Bird;
import se.fanxing.bean.Tiger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *  不使用泛型的缺点
 *
 */
public class Demo1 {

    public static void test01() {
        System.out.println("使用泛型之后 。。。 ");

        // 泛型指定了集合中存储的对象类型，如果存储其他数据类型 就会编译报错
        // 只是在编译阶段给编译器使用的 是编译期间的新特性 在运行阶段没有作用
        // 集合中取出的元素类型 都是指定的
        // 如果要调用子类型的方法还是需要进行向下转型

        // 钻石表达式  自动类型推断 jdk8之后
        List<Animal> animals = new ArrayList<>();
        //animals.add("nihao");

        Iterator<Animal> iterator = animals.iterator();

        animals.add(new Tiger());
        animals.add(new Bird());



        animals.forEach(Animal::doSth);
    }

    public static void main(String[] args) {
        test01();

        List animals = new ArrayList();

        animals.add(new Tiger());
        animals.add(new Bird());

        Object o = animals.get(0);
        System.out.println(o.getClass());


        animals.stream().forEach(x-> {
            if (x instanceof Animal) {
                ((Animal) x).doSth();
            }
        });


        System.out.println(animals.get(0));
    }
}
