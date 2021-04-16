package com.plural.spring.fundamentals.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFieldInclude {
    public String value() default "";
}