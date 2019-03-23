package com.sigleton.hungry.register;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterMap {
    private RegisterMap(){

    }

    private static Map<String,Object> register = new ConcurrentHashMap<String, Object>();

    public static RegisterMap getInstance(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }

        if(register.get(name) == null){
            register.put(name, new RegisterMap());
        }

        return (RegisterMap) register.get(name);
    }
}
