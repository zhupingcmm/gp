package com.MyBatisTest.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.Reader;

public class DBTools {
    public static SqlSessionFactory sessionFactory;

    static{
/*        InputStream inputStream = null;*/
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
            //构建sqlSession的工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
/*
            inputStream = DBTools.class.getClassLoader().getResourceAsStream("mybatis.cfg.xml");

            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
/*            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }

    }
    //创建能执行映射文件中sql的sqlSession
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

}