package com.sigleton.hungry.lazy;

public class LazyTwo {
    private LazyTwo(){}
    private static class LazyHolder{
        private static final LazyTwo LAZY_TWO = new LazyTwo();
    }

    public static LazyTwo getInstance(){
       return LazyHolder.LAZY_TWO;
    }
}
