package com.rpc.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPTranceport {

    private String host;
    private int port;

    public TCPTranceport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket(){
        System.out.println(" get connection");
        Socket socket = null;
        try{
            socket = new Socket(host,port);
        }catch (Exception e){
            e.printStackTrace();
        }
        return socket;
    }

    public Object send(RpcRequest request){
        Socket socket =null;
        Object object = null;
        try{
            socket = newSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            object = objectInputStream.readObject();

            objectOutputStream.close();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(socket !=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return object;
    }

}
