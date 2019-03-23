package com.strategy;

public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WeChatPay());

    private PayMent payMent;

    PayType(PayMent payMent) {
        this.payMent = payMent;
    }

    public PayMent get(){
        return this.payMent;
    }
}
