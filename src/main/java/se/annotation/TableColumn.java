package se.annotation;

public @interface TableColumn {

    TypeEnum type() default TypeEnum.VARCHAR;
}
