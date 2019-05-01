package com.zpMybatis.v2.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MFInvocation {
    private final Object target;
    private final Method method;
    private final Object [] args;

    public MFInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,args);
    }
}
