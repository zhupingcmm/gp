package com.zpMybatis.v2.Mapper;

import com.zpMybatis.User;
import com.zpMybatis.v2.annotation.Mapper;
import com.zpMybatis.v2.annotation.Sql;


@Mapper
public interface MFTestMapper {
    @Sql(value = "select * from users where id = ?")
    User queryById(int id );
}
