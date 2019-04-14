package com.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        try{
            server = new ServerSocket(8080);
            Socket socket = server.accept();
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream os = new PrintStream(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("client :" + is.readLine());
            String line = sin.readLine();
            while (!line.equals("bye")){
                os.println(line);
                os.flush();
                System.out.println("Server line :" + line);
                System.out.println("Client :" + is.readLine());
                line = sin.readLine();
            }

            is.close();
            os.close();
            sin.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            server.close();

        }
    }
}
