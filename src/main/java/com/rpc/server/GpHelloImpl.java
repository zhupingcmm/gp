package com.rpc.server;

public class GpHelloImpl implements IGpHello {
    public String sayHello(String msg) {
        return "HELLO," + msg;
    }
}
