package com.observer.core;

import java.lang.reflect.Method;

public class Event {
    private Object source;
    private Object target;
    private Method callback;
    private String trigger;
    private long time;



    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public long getTime() {
        return time;
    }

    Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Object getSource() {
        return source;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    Event setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public String getTrigger() {
        return trigger;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                '}';
    }
}
