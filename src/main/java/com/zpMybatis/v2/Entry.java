package com.zpMybatis.v2;

import com.zpMybatis.v2.Executor.MFSimpleExecutorImpl;
import com.zpMybatis.v2.MFSqlSession.MFSqlSession;
import com.zpMybatis.v2.Mapper.MFTestMapper;
import com.zpMybatis.v2.configuration.MFConfiguration;

public class Entry {

    public static void main(String[] args) {
        MFConfiguration configuration = new MFConfiguration();
        configuration.setMapperPath("com.zpMybatis.v2.Mapper.MFTestMapper");
        configuration.setPluginPath("com.zpMybatis.v2.plugin.ZPPlugin");
        MFSqlSession sqlSession = configuration.build();
        MFTestMapper mfTestMapper =sqlSession.getMapper(MFTestMapper.class);
        mfTestMapper.queryById(1);
    }
}
