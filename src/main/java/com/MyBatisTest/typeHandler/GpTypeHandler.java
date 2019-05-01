package com.MyBatisTest.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(value = JdbcType.TINYINT, includeNullJdbcType = true)
public class GpTypeHandler extends BaseTypeHandler <Integer>{

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer integer, JdbcType jdbcType) throws SQLException {
        System.out.println("gp typeHandler");
        preparedStatement.setInt(i,integer);

    }

    public Integer getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("gp typeHandler");
        return null;
    }

    public Integer getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("gp typeHandler");
        return null;
    }

    public Integer getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("gp typeHandler");
        return null;
    }

}
