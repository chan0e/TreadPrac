package org.example;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class TestClothingStore {
    public static void main(String[] args){
        Semaphore dressrooms  = new Semaphore(5);
        Thread [] customers = new Thread[10];

        for(int i = 0 ; i < customers.length; i++){
            int finalI = i;
            customers[i] = new Thread(() -> {
                try {
                    System.out.println("손님"  + finalI + "대기");
                    dressrooms.acquire();
                    System.out.println("손님 " + finalI +  "입장 " + dressrooms.drainPermits());
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000,5000));
                    dressrooms.release();
                    System.out.println( finalI + "손님 퇴장");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            customers[i].start();
        }
    }
}
