package com.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientSocketDemo {
    public static void main(String[] args) {
        Socket socket = null;
        PrintStream printStream = null;
        BufferedReader bufferedReader = null;

        try {
            socket =  new Socket("127.0.0.1",8080);

            printStream = new PrintStream(socket.getOutputStream());
            printStream.println("client hello");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(printStream != null){
                printStream.close();
            }
        }
    }
}
