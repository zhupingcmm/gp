package com.zpMybatis.v2.MFSqlSession;

import com.zpMybatis.v2.Executor.MFExecutor;
import com.zpMybatis.v2.configuration.MFConfiguration;

public class MFSqlSession {

    private MFConfiguration configuration;
    private MFExecutor executor;

    public MFSqlSession(MFConfiguration configuration, MFExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> type){
        return configuration.getMapper(type, this);
    }

    public <T> T selectOne(String statement, Object parameter){
        return executor.query(statement, parameter);
    }
}
