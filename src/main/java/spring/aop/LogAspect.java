package spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(private * *(..))")
    public void aspect(){}

    @Before("aspect()")
    public void log() {
        System.out.println("[service begin]");
    }

    @After("aspect()")
    public void logreturn() {
        System.out.println("service end");
    }


    @Around("execution(public String spring.aop.player.around(String))")
    public void aroundType(ProceedingJoinPoint p) {
        System.out.println("[around]");
        try {
            p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("[around]");
    }
}
