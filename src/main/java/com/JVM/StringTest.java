package com.JVM;

public class StringTest {
    private static String name;
    public static void main(String[] args) {
        f1();
        f2();
        setName("zp");
    }

    public static String f1(){
        String abc = null;
        for (int i =0; i<10; i++){
            abc = abc + i;
        }

        return abc;
    }

    public static StringBuilder f2(){
        StringBuilder stringBuilder = null;
        for (int i =0; i<10; ++i) {
            stringBuilder = stringBuilder.append(i);
        }

        return  stringBuilder;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StringTest.name = name;
    }
}
