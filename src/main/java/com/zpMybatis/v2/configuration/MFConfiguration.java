package com.zpMybatis.v2.configuration;

import com.zpMybatis.v2.Executor.MFExecutor;
import com.zpMybatis.v2.Executor.MFSimpleExecutorImpl;
import com.zpMybatis.v2.MFSqlSession.MFSqlSession;
import com.zpMybatis.v2.annotation.Mapper;
import com.zpMybatis.v2.annotation.Sql;
import com.zpMybatis.v2.bind.MFMapperProxy;
import com.zpMybatis.v2.plugin.MFInterceptor;
import com.zpMybatis.v2.plugin.MFInterceptorChain;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MFConfiguration {

    public static Map<String, Map<String, String>> mapperRegistry = new HashMap<String, Map<String, String>>();
    private MFInterceptorChain interceptorChain = new MFInterceptorChain();
    private static String mapperPath = null;
    private static String pluginPath = null;

    public static void setPluginPath(String pluginPath) {
        MFConfiguration.pluginPath = pluginPath;
    }

    public static void setMapperPath(String mapperPath) {
        MFConfiguration.mapperPath = mapperPath;
    }

    public <T> T getMapper(Class<T> type, MFSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{type}, new MFMapperProxy(sqlSession));
    }

    private <T> void generateMapperRegistry(){
        try {
            Class<?> clazz = Class.forName(mapperPath);
            if(clazz.isAnnotationPresent(Mapper.class)){
                String mapperName = null;
                if (!"".equals(clazz.getAnnotation(Mapper.class).value())){
                    mapperName = clazz.getAnnotation(Mapper.class).value();
                }
                mapperName = clazz.getName();
                Method[] methods =clazz.getMethods();
                for (Method method : methods){
                    if(method.getAnnotation(Sql.class) != null){
                        Map<String, String> methodAndSql = new HashMap<String, String>();

                        methodAndSql.put(method.getName(),method.getAnnotation(Sql.class).value());
                        mapperRegistry.put(mapperName, methodAndSql);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(mapperRegistry);
    }

    public MFSqlSession build(){
        generateMapperRegistry();
        generatePluginRegistry();
        return new MFSqlSession(this, newExecutor());
    }

    private MFExecutor newExecutor(){
        MFExecutor target = new MFSimpleExecutorImpl();
        target = (MFExecutor) interceptorChain.pluginAll(target);
        return target;
    }


    private void generatePluginRegistry() {

        try {
            Class<?> clazz = Class.forName(pluginPath);
            interceptorChain.addInterceptor((MFInterceptor) clazz.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
