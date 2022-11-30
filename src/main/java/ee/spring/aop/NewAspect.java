package ee.spring.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.instrument.ClassFileTransformer;

@Aspect
@EnableLoadTimeWeaving
public class NewAspect {

    @PostConstruct
    void init() {

        System.out.println("初始化方法");
    }


    @AfterReturning(pointcut = "execution(* ee.spring.aop.Service.mock(..))")
    public  void dosth() {
        System.out.println("doAfterReturning");
    }



}
