package com.strategy;

public class AliPay implements PayMent{
    public PayState pay(String uid, double amount) {
        System.out.println(" welcome use ali pay");
        System.out.println(" start to search money");
        return new PayState(200,"zhi fu cheng gong", "huan yin xia cia shi yong");
    }
}
