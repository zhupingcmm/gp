package com;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        oos.writeObject(new Person("zp", 20, "nan"));
        oos.writeObject(new Person("zmm", 20, "nan"));
        oos.writeObject(new Person("cmm", 20, "nan"));
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        Person p = null;

        try{
//            while((p = (Person)ois.readObject()) != null){
//                System.out.println(p);
//            }
            while (ois.available()>0){
                System.out.println(ois.readObject());
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        ois.close();
    }
}
