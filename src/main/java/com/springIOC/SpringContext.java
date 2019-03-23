package com.springIOC;

import com.springIOC.anotation.Controller;
import com.springIOC.anotation.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;


public class SpringContext {
    private static Properties configContext = new Properties();
    private static final String configLocation = "application.properties";
    private List<String> classNames = new ArrayList<String>();
    Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public SpringContext() {
        init();
    }

    public void init() {
        //load
        doLoadConfig(configLocation);

        //doScan
        doScan(configContext.getProperty("scanpackage"));

        //doRegister
        doRegister(classNames);

        //doInject()
        doInject();

        System.out.println(classNames);
    }

    private void doInject() {
    }

    private void doRegister(List<String> classNames) {
        for(String className : classNames){
            try {
                Class<?>clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Controller.class)){
                    ioc.put(lowerFirstCase(clazz.getSimpleName()),clazz.newInstance());
                }else if (clazz.isAnnotationPresent(Service.class)){
                    Service service = clazz.getAnnotation(Service.class);
                    String beanName = service.value();
                    if("".equals(beanName.trim())){
                        beanName = lowerFirstCase(clazz.getSimpleName());
                    }

                    Object instance = clazz.newInstance();

                    ioc.put(beanName, instance);

                    Class<?>[]interfaces =clazz.getInterfaces();
                    for(Class<?> i : interfaces){
                        ioc.put(beanName, instance);
                    }

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private void doScan(String scanpackage) {
        URL url = this.getClass().getClassLoader().getResource(scanpackage.replaceAll("\\.","/"));
        File classDir = new File(url.getFile());
        for(File file: classDir.listFiles()){
            if(file.isDirectory()){
                doScan(scanpackage + "." +file.getName());
            }else {
                classNames.add(scanpackage+"."+file.getName().replaceAll(".class",""));

            }
        }
        System.out.println(url);
    }

    private void doLoadConfig(String configLocation) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(configLocation);
        try {
            configContext.load(in);
            System.out.println(configContext.get("scanpackage"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String lowerFirstCase(String str){
        char [] chars = str.toCharArray();
        chars[0] +=32;
        return new String(chars);
    }

    public static void main(String[] args) {
        SpringContext ctx =new SpringContext();

    }


}
