package com.delegate.leader;

public class TargetB implements ITTarget{
    public Object doing(String commond) {
        return "I will do " + commond;
    }
}
