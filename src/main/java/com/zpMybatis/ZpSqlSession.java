package com.zpMybatis;

import java.lang.reflect.Proxy;

public class ZpSqlSession {
    private ZpConfiguration zpConfiguration;
    private ZpExecutor zpExecutor;

    public ZpSqlSession(ZpConfiguration zpConfiguration, ZpExecutor zpExecutor) {
        this.zpConfiguration = zpConfiguration;
        this.zpExecutor = zpExecutor;
    }

    public <T> T getMapper(Class<T> clazz){
        return zpConfiguration.getMapper(clazz, this);
    }

    public <T> T selectOne(String statement, String parameter){
        return zpExecutor.query(statement, parameter);
    }
}
