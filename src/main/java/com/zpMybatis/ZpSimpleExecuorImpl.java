package com.zpMybatis;

public class ZpSimpleExecuorImpl implements ZpExecutor {
    public <T> T query(String statement, String parameter) {
        return (T)"SA";
    }
}
