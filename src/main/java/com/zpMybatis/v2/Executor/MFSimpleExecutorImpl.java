package com.zpMybatis.v2.Executor;

import com.zpMybatis.v2.Executor.MFExecutor;

import java.sql.*;

public class MFSimpleExecutorImpl implements MFExecutor {

    public <E> E query(String statement, Object parameter) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
            String sql = "select * from users where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
//            preparedStatement.setInt(1,1);
            preparedStatement.setInt(1, ((Integer) parameter));
//            preparedStatement.setString(Integer.parseInt("id"),);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            while (rs.next()){
                rs.getString("id");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("aa");
        return null;
    }
}
