package com.proxy.JDK;

import com.proxy.staticed.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JDKTest {
    public static void main(String[] args) throws IOException {
        Person person = (Person) new JDKMeiPo().getInstance(new CMM());
        System.out.println(person.getClass());
        person.findLove();

        //把动态代理类些出去
        byte[] bytes =ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("C:\\Temp\\$Proxy0.class");
        os.write(bytes);
        os.close();

    }
}
