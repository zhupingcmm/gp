package com.delegate.leader;

public class TargetA implements ITTarget{
    public Object doing(String commond) {

        return "I will do " + commond;
    }
}
