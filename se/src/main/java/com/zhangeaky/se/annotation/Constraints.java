package com.zhangeaky.se.annotation;

public @interface Constraints {

    String value();

    String name() default "";
}
