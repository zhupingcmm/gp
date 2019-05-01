package com.rmi.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {

    protected HelloServiceImpl() throws RemoteException {
        super();
    }


    public String sayHello(String msg) throws RemoteException{
        return "Hello, "+ msg;
    }
}
