package com.code.testCore.config.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface TestField {
    boolean PK() default false;
    boolean NotNull() default false;
    boolean Unique() default false;
    boolean FK() default false;
}
