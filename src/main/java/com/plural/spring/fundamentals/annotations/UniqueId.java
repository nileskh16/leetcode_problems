package com.plural.spring.fundamentals.annotations;

import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Validated
public @interface UniqueId {
    public String message() default "The entity with ID already exists";
    Class<?> [] groups() default {};
}
