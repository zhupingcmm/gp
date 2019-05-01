package com.rmi.Client;
import com.rmi.Server.IHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        try {
            IHelloService iHelloService = (IHelloService)Naming.lookup("rmi://127.0.0.1/hello");
            System.out.println(iHelloService.sayHello("zp"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
