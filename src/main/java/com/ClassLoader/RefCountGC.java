package com.ClassLoader;

public class RefCountGC {
    public Object instance = null;
    private byte[]bigSize = new byte[2*1024*1024];

    public static void main(String[] args) {
        RefCountGC r1 = new RefCountGC();
        RefCountGC r2 = new RefCountGC();

        r1.instance = r2;

        r2.instance = r1;

        r1 = null;
        r2 =null;

        System.gc();

    }
}
