package com.observer;

import com.observer.core.Event;

import java.lang.reflect.Method;

public class ObserverTest {
    public static void main(String[] args) {
        try{
            Observer observer = new Observer();
            Method advice = Observer.class.getMethod("advice", Event.class);

            Subject subject = new Subject();
            subject.addLisenter(SubjectEventType.ON_ADD,observer,advice);
            subject.add();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
