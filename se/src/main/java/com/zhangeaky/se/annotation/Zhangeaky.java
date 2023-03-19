package com.zhangeaky.se.annotation;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Zhangeaky {

    @AliasFor("nickName")
    String huaming() default "yida";

    @AliasFor("huaming")
    String nickName() default "yida";

    long gonghao() default 328153L;

    String realName() default "zhangyikai.zyk";
}
