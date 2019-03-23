package com.ClassLoader;

import java.util.ArrayList;
import java.util.List;

public class JvmTest {
    byte[] byteArray = new byte[1 * 1024 * 1024];
    public static void main(String[] args) {
        List<JvmTest> list = new ArrayList<JvmTest>();
        int count = 0;
        try{
            while (true){
                list.add(new JvmTest());
                count ++;
            }
        }catch (Throwable e){
            System.out.println("count: " + count);
            e.printStackTrace();
        }

    }
}
