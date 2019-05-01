package com.zpMybatis.v2.plugin;

import com.zpMybatis.v2.Executor.MFExecutor;

import java.util.ArrayList;
import java.util.List;

public class MFInterceptorChain {
    private final List<MFInterceptor> interceptors = new ArrayList<MFInterceptor>();



    public void addInterceptor(MFInterceptor interceptor){
        interceptors.add(interceptor);
    }

    public  Object pluginAll(Object target) {
        for (MFInterceptor interceptor : interceptors){
            target = interceptor.plugin(target);
        }

        return target;
    }
}
