package com.strategy;

public class WeChatPay implements PayMent{
    public PayState pay(String uid, double amount) {
        System.out.println(" welcome use WeChat");
        System.out.println(" start to search money");
        return new PayState(200,"zhi fu cheng gong", "huan yin xia cia shi yong");
    }
}
