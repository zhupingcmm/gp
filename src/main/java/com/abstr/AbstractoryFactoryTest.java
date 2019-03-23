package com.abstr;

public class AbstractoryFactoryTest {
    public static void main(String[]args){
        MilkFactory milkFactory = new MilkFactory();
        System.out.println( milkFactory.getMengNiu().getMilk());

    }
}
