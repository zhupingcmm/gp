package com.protocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;
        PrintStream printStream = null;

        try {
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());

            printStream.println("Server hello");
            System.out.println(bufferedReader.readLine());
        }catch (Exception e){

        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
