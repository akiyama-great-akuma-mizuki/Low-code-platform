package com.horsecoder.yulinOA.config.client;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleRpcClient {

    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";
}
