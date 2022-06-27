package se.basic;

/**
 * 学习静态类相关知识
 *
 */
public class StaticClassDemo {

    class innerDemo{

    }



    public static staticInnerDemo newDemo() {
        return new staticInnerDemo();
    }

    static class staticInnerDemo {

    }

    public static void main(String[] args) {

        staticInnerDemo innerDemo = newDemo();

        System.out.println(newDemo().getClass().getCanonicalName());

    }
}

class tmp {

    public static void main(String[] args) {

        StaticClassDemo.staticInnerDemo ii = new StaticClassDemo.staticInnerDemo();


    }
}
