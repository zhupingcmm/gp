package com.MyBatisTest;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test {
    public static void main(String[] args) throws IOException {
        //InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();




        //inputStream.close();
    }
}
