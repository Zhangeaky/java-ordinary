package ee.spring.aop;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

public class CGlibProxy {


    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(player.class);
        enhancer.setCallback(new Callback() {
        });
    }
}
