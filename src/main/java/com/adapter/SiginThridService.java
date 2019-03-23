package com.adapter;

public class SiginThridService {
    private SiginService service;

    public SiginThridService(SiginService service) {
        this.service = service;
    }

    public ResultMsg loginForQQ(String openId){
        ResultMsg msg =service.regist(openId,null);
        String pwd = null;
        if("200".equals(msg.getCode())){
            pwd = (String) msg.getData();
        }

        return service.login(openId, pwd);
    }

}
