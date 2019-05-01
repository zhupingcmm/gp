package com.zpMybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ZpMapperProxy implements InvocationHandler {

    private ZpSqlSession sqlSession;

    public ZpMapperProxy(ZpSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(ZpConfiguration.testMapperXMl.namespace)){
            String sql = ZpConfiguration.testMapperXMl.methodAndSqlMappering.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
        }

        return method.invoke(this,args);
    }
}
