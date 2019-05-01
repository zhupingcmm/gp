package com.zpMybatis.v2.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface MFSignature {
    Class<?> type();

    String method();

    Class<?>[] args();
}
