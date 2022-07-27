package se.proxy;

public class DynamicProxyDemo {


    public static void main(String[] args) {

        UserService ss = new UserServiceImpl();

        MyInvocationHandler handler = new MyInvocationHandler(ss);
        UserService proxy = (UserService)handler.getProxy();
        proxy.add();
    }
}
