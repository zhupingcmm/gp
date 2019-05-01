package com.zpMybatis;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ZpConfiguration {
    public <T> T getMapper(Class<T> clazz, ZpSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new ZpMapperProxy(sqlSession));
    }

    static class testMapperXMl{
        public static final String namespace ="com.zpMybatis.TestMapper";
        public static final Map<String, String> methodAndSqlMappering = new HashMap<String, String>();
        static {
            methodAndSqlMappering.put("queryById","select * from users where id =%d");
        }
    }
}
