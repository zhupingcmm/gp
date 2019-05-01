package com.rpc.server;

import com.rpc.client.RpcRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ProcessorHandler implements Runnable {
    private Object service;
    private Socket socket;

    public ProcessorHandler(Object service, Socket socket) {
        this.service = service;
        this.socket = socket;
    }

    public void run() {
        ObjectInputStream inputStream = null;
        try{
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) inputStream.readObject();
            Object result = invoke(rpcRequest);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);

            objectOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object []args = request.getParameters();
        Class<?> []types = new Class[args.length];
        for(int i = 0 ; i<args.length; i++){
            types[i] = args[i].getClass();
        }

        Method method = service.getClass().getMethod(request.getMethodName(),types);
        return  method.invoke(service,args);
    }
}
