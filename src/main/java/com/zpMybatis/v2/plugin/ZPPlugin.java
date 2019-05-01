package com.zpMybatis.v2.plugin;

import com.zpMybatis.v2.Executor.MFExecutor;
import com.zpMybatis.v2.annotation.MFIntercepts;
import com.zpMybatis.v2.annotation.MFSignature;

@MFIntercepts(value = {@MFSignature(
        type = MFExecutor.class,
        method = "query",
        args = {String.class, Object.class}

)})
public class ZPPlugin implements MFInterceptor{
    public Object intercept(MFInvocation invocation) throws Throwable {
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }
}
