package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestHoldAndWaitDeadLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread task1 = new Thread(() -> {
            while (!Thread.interrupted()) {

                try{
                    lock.lock();
                    System.out.println("Task1 lock");
                    Thread.sleep(1000);
                    lock.unlock();
                    System.out.println("Task1 unlock");
                }catch (InterruptedException ignore){

                }


            }
        });

        Thread task2 = new Thread(() -> {
            while (!Thread.interrupted()) {

                try{
                    lock.lock();
                    System.out.println("Task2 lock");
                    Thread.sleep(1000);
                    lock.unlock();
                    System.out.println("Task2 unlock");
                }catch (InterruptedException ignore){
                    Thread.currentThread().interrupt();
                }

            }

        });

        task1.start();
        task2.start();

        try{
            Thread.sleep(2000);
            task2.interrupt();
        }catch(InterruptedException ignore){

        }
    }
}
