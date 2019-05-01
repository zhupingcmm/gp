package com.rpc.server;

public class ServerDemo {

    public static void main(String[] args) {
        IGpHello iGpHello = new GpHelloImpl();
        RemoteServer remoteServer = new RemoteServer();
        remoteServer.publisher(iGpHello,8888);
    }
}
