package com.serializer;

import java.io.IOException;

public interface ISerializer {
    <T>byte[] serializer(T obj);
    <T> T deSerializer(byte[]data, Class<T> clazz) throws IOException;

}
