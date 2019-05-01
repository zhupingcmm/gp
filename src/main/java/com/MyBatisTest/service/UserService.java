package com.MyBatisTest.service;

import com.MyBatisTest.Log;
import com.MyBatisTest.beans.UserBean;
import com.MyBatisTest.mapper.UserMapper;
import com.MyBatisTest.tools.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {


    public static void main(String[] args) {
//        insertUser();
//        deleteUser();
//        selectUserById();
/*        selectAllUser();*/
        UserBean userBean = new UserBean(1,"d","1999",  80000.222);
        updateUser(userBean);
    }

    private static void updateUser(UserBean userBean){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        try {
            Log.logger.info("start update");
            mapper.updateUser(userBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 新增用户
     */
    private static void insertUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean("a", "1314520", 7000.0);
        try {
            mapper.insertUser(user);
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    /**
     * 删除用户
     */
    private static void deleteUser(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(1);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    /**
     * 根据id查询用户
     */
    private static void selectUserById(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            UserBean user= mapper.selectUserById(2);
            System.out.println(user.toString());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 查询所有的用户
     */
    private static void selectAllUser(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            List<UserBean> user=mapper.selectAllUser();
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


}