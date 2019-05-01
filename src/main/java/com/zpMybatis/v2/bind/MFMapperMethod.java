package com.zpMybatis.v2.bind;

public class MFMapperMethod {

    private Object[]args = null;

    public MFMapperMethod(Object[] args) {
        this.args = args;
    }

    public Object convertArgs(Object[] args) {
        if (args.length ==1){
            return args[0];
        }
        return null;
    }
}
