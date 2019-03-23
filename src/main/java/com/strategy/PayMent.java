package com.strategy;

public interface PayMent {

    PayState pay(String uid, double amount);
}
