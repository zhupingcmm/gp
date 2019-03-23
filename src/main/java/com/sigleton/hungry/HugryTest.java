package com.sigleton.hungry;

import java.util.concurrent.CountDownLatch;

public class HugryTest {
    public static void main(String[] args) {

        int count =100;
        final CountDownLatch latch = new CountDownLatch(count);

        for(int i =0; i<count; i++){
            new Thread(){
                @Override
                public void run() {
                    Hungry.getInstance();
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
