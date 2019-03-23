package com.proxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeiPo implements InvocationHandler {

    private CMM target;


    public Object getInstance(CMM target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" I am meipo , I start to wu se");
        method.invoke(this.target,args);
        System.out.println(" he shi jiu ke yi ban shi");
        return null;
    }
}
