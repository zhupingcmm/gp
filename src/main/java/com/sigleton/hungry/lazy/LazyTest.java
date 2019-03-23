package com.sigleton.hungry.lazy;

import java.util.concurrent.CountDownLatch;

public class LazyTest {
    public static void main(String[] args) {
        int count =100;

        final CountDownLatch latch = new CountDownLatch(count);

        for (int i =0; i< count; i++){
            new Thread(){
                @Override
                public void run() {
                    Object obj =LazyTwo.getInstance();
                    System.out.println(System.currentTimeMillis() + ":"+ obj);

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
