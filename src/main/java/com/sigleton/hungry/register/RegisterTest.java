package com.sigleton.hungry.register;

import java.util.concurrent.CountDownLatch;

public class RegisterTest {
    public static void main(String[] args) {
        int count = 100;
        final CountDownLatch latch = new CountDownLatch(count);

        for(int i =0; i<count; i++){
            new Thread(){
                @Override
                public void run() {
                    RegisterMap registerMap = RegisterMap.getInstance("ZH");
                    System.out.println(System.currentTimeMillis() + ":" + registerMap);
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }.start();

            latch.countDown();
        }
    }
}
