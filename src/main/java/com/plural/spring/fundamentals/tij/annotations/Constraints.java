package com.plural.spring.fundamentals.tij.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {

    boolean isNull() default true;
    boolean isPrimary() default false;
    boolean isUnique() default false;
}
