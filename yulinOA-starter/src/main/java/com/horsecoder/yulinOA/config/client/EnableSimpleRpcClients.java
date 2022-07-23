package com.horsecoder.yulinOA.config.client;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface EnableSimpleRpcClients {

    String[] value() default {};

    String[] basePackages() default {};
}

