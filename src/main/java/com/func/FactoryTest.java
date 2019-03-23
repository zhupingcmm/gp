package com.func;

public class FactoryTest {
    public static void main(String[]args){
        Factory factory = new TelunsuFactory();
        factory.getMilk();
        System.out.println(factory.getMilk().getMilk());
    }
}
