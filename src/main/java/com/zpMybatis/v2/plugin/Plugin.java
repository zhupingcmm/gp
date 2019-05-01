package com.zpMybatis.v2.plugin;

import com.zpMybatis.v2.annotation.MFIntercepts;
import com.zpMybatis.v2.annotation.MFSignature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Plugin implements InvocationHandler {

    private Object target;
    private MFInterceptor interceptor;
    private Map<Class<?>, Set<Method>> signatureMap;

    public Plugin(Object target, MFInterceptor interceptor, Map<Class<?>, Set<Method>> signatureMap) {
        this.target = target;
        this.interceptor = interceptor;
        this.signatureMap = signatureMap;
    }

    public static Object wrap(Object target, MFInterceptor interceptor){
        Class<?>clazz = target.getClass();
        Map<Class<?>, Set<Method>> signatureMap = getSignatureMap(interceptor);
        Class<?> []interfaces = getAllInterfaces(clazz, signatureMap);
        return Proxy.newProxyInstance(clazz.getClassLoader(),interfaces,new Plugin(target,interceptor,signatureMap));
    }

    private static Class<?>[] getAllInterfaces(Class<?> clazz, Map<Class<?>, Set<Method>> signatureMap) {
        Set<Class<?>>interfaces = new HashSet<Class<?>>();
        while (clazz != null){
             for (Class<?> c : clazz.getInterfaces()){
                 if(signatureMap.containsKey(c)){
                     interfaces.add(c);
                 }
             }
            clazz =clazz.getSuperclass();
        }
        return interfaces.toArray(new Class[interfaces.size()]);
    }


    private static Map<Class<?>, Set<Method>> getSignatureMap(MFInterceptor interceptor) {
        MFIntercepts interceptsAnnotation=interceptor.getClass().getAnnotation(MFIntercepts.class);
        MFSignature [] sigs =interceptsAnnotation.value();
        Map<Class<?>,Set<Method>> sigMap = new HashMap<Class<?>, Set<Method>>();
        for(MFSignature sig : sigs){
            Set<Method> methods = sigMap.get(sig.type());
            if(methods == null){
                methods = new HashSet<Method>();
                sigMap.put(sig.type(),methods);
            }
            try {
                Method method = sig.type().getMethod(sig.method(),sig.args());
                methods.add(method);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return sigMap;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("plugin: method name "+ method.getName());
        Set<Method> methods =signatureMap.get(method.getDeclaringClass());
        if(methods != null && methods.contains(method)){
            return interceptor.intercept(new MFInvocation(target, method, args));
        }
        return method.invoke(target,args);
    }
}
