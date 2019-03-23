package com.observer;

import com.observer.core.Event;

public class Observer {
    public void advice(Event e){
        System.out.println("==========notification print log=======\n" + e);
    }
}
