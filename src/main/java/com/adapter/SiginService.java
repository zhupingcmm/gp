package com.adapter;

public class SiginService {

    public ResultMsg regist(String userName, String Password){
        return new ResultMsg(200,"regist","regist successfully");
    }
    public ResultMsg login(String userName, String passWord){
        return new ResultMsg(200,"login","login successfully");
    }
}
