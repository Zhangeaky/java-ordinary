package se.annotation.spring;

import org.springframework.core.annotation.AliasFor;
import se.annotation.Zhangeaky;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Zhangeaky
public @interface Try {

    @AliasFor(attribute = "gonghao", annotation = Zhangeaky.class)
    String tryCase() default "";
}
