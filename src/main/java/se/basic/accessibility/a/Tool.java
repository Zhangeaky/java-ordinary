package se.basic.accessibility.a;

public class Tool {

    protected void use() {
        System.out.println("do sth");
    }

    protected static void see() {
        System.out.println("protected method see !");
    }
}

class Test {
    public static void main(String[] args) {
        Tool.see();
        Tool tool = new Tool();
        tool.use();

    }
}
