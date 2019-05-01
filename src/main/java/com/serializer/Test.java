package com.serializer;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ISerializer iSerializer = new JavaSerializer();
        Person person = new Person();
        person.setAge(19);
        person.setName("zp");
        byte[]bytes = iSerializer.serializer(person);

        System.out.println(bytes);

        Person person1 = iSerializer.deSerializer(bytes,Person.class);

        System.out.println(person1);

    }
}
