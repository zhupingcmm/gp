package com.zpMybatis.v2.bind;

import com.zpMybatis.v2.MFSqlSession.MFSqlSession;
import com.zpMybatis.v2.configuration.MFConfiguration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MFMapperProxy implements InvocationHandler {

    private final MFSqlSession sqlSession;

    public MFMapperProxy(MFSqlSession sqlSession ){
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<String, String> methodAndSql =  MFConfiguration.mapperRegistry.get(method.getDeclaringClass().getName());
        if( methodAndSql != null){
            String sql = methodAndSql.get(method.getName());
            MFMapperMethod mapperMethod = new MFMapperMethod(args);
            Object param = mapperMethod.convertArgs(args);
            return sqlSession.selectOne(sql,param);
        }
        return method.invoke(this,args);
    }
}
