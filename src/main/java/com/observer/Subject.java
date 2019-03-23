package com.observer;

import com.observer.core.EventLisenter;

public class Subject extends EventLisenter {

    public void add(){
        System.out.println("add method");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("remove method");

        trigger(SubjectEventType.ON_REMOVE);
    }
}
