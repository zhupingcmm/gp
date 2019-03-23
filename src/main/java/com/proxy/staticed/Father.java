package com.proxy.staticed;

public class Father {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void findLove(){
        System.out.println("wu se");
        son.findLove();
        System.out.println("parent conversation");
    }

    public void findJob(){
        System.out.println("wu se");
        son.findJob();
        System.out.println("parent conversation");
    }
}
