package com.strategy;

public class PayTest {
    public static void main(String[] args) {
        Order order = new Order("1","2",123.123);
        System.out.println(order.pay(PayType.ALI_PAY));
    }
}
