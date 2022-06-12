package se.basic.classRelated;

/**
 * @Author: jiegege
 * @Date: 2022/2/12 4:50 下午
 * @address: hangzhou
 * @description:
 *      1. 内部类和内部静态类的展示
 *      2. 普通内部类可以获取外层对象引用。但不用创建静态方法,不能在外部被创建。
 *
 *
 *
 *
 *
 * @Version 1.0
 */
public class staticClassDemo {

    private long id;

    // 普通内部类只能在类内部被创建
    private normalInnerClass instance = new normalInnerClass();

    class normalInnerClass {

        private long innerId = id+100;

    }

    protected static class tool {
        public  tool() {
            System.out.println("tool ...");
            //System.out.println(id);
        }
    }

    public static void main(String[] args) {
        staticClassDemo demo = new staticClassDemo();
        //normalInnerClass normalInnerClass = new normalInnerClass();

    }
}

class Test {
    public static void main(String[] args) {
        new staticClassDemo.tool();
        //new staticClassDemo.normalInnerClass();

    }
}
