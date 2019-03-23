package com.sigleton.hungry;

public class Hungry {

    private Hungry(){

    }
    private static final Hungry hungry = new Hungry();

    public static Hungry getInstance(){
        System.out.println(System.currentTimeMillis() + ":" + hungry);
        return hungry;
    }

}
