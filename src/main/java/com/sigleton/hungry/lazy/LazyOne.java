package com.sigleton.hungry.lazy;

public class LazyOne {
    private LazyOne(){

    }
    private static LazyOne lazyOne = null;

    public static synchronized LazyOne getInstance(){
        if(lazyOne == null){
            lazyOne = new LazyOne();
        }

        return lazyOne;
    }
}
