package com.zpMybatis.v2.Executor;

public interface MFExecutor {
    <E> E query (String statement, Object parameter);
}
