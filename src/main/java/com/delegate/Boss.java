package com.delegate;

import com.delegate.leader.ITTarget;
import com.delegate.leader.Leader;

public class Boss {

    public static void main(String[] args) {
        ITTarget itTarget = Leader.getInstance();
        Object result = itTarget.doing("login");
        System.out.println(result);
    }
}
