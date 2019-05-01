package com.zpMybatis;

public interface ZpExecutor {
    <T> T query(String statement, String parameter);
}
