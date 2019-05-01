package com.zpMybatis.v2.plugin;

public interface MFInterceptor {
    Object intercept(MFInvocation invocation) throws Throwable;
    Object plugin(Object target);

}
