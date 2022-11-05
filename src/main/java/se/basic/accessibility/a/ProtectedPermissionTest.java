package se.basic.accessibility.a;

public class ProtectedPermissionTest {

    public static void main(String[] args) {
        Tool.see();
        Tool tool = new Tool();
        tool.use();
    }
}
