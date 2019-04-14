package com.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8080);
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            String line = sin.readLine();
            while (!line.equals("bye")){
                os.println(line);
                os.flush();
                System.out.println("Client:" + line);
                System.out.println("Server:" + is.readLine());
                line = sin.readLine();
            }

            os.close();
            sin.close();
            is.close();

        }catch (Exception e){

        }finally {
            socket.close();
        }
    }
}
