package com.proxy.staticed;

public class ProxyStaticTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findJob();
    }
}
