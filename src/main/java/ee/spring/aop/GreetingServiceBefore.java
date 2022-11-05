package ee.spring.aop;

import se.bean.GreetingService;
import se.bean.javabean.GenericGreetingService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class GreetingServiceBefore implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("[BEFORE]: 尊敬的" + (String) objects[0] + "让我来为您服务！" );
    }

    public static void main(String[] args) {

        //被代理的目标类创建。
        GreetingService service = new GenericGreetingService();
        BeforeAdvice beforeAdvice = new GreetingServiceBefore();

        ProxyFactory proxy = new ProxyFactory();
        proxy.setTarget(service);
        //因为是将增强类直接加到数组里面，即使是相同的都会往里面加，所以会执行两遍。
        proxy.addAdvice(beforeAdvice);
        proxy.addAdvice(beforeAdvice);
        GreetingService proxy1 = (GreetingService)proxy.getProxy();
        proxy1.greet("zhangyikai");

    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("[AFTER]: " + (String)objects[0]);
    }
}
