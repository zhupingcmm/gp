package com.rpc.client;

import com.rpc.server.IGpHello;

public class ClientDemo {
    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        IGpHello iGpHello = rpcClientProxy.clientProxy(IGpHello.class, "localhost",8888);
        System.out.println(iGpHello.sayHello("cmm"));
    }
}
