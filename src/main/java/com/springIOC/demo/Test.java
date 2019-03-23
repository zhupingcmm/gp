package com.springIOC.demo;

import com.springIOC.anotation.Autowired;
import com.springIOC.anotation.Controller;

@Controller
public class Test {

    public Test() {
    }

    @Autowired Person person;

    public void setName(String name){
        person.setName(name);
    }

    public String getName(){
        System.out.println(person.getName());
        return person.getName();
    }

}
