package com.adapter;

public class SiginServiceTest {
    public static void main(String[] args) {
        SiginThridService siginThridService = new SiginThridService(new SiginService());
        ResultMsg msg = siginThridService.loginForQQ("sdsad");
        System.out.println(msg);
    }
}
