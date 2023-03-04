package org.example;

public class TestCircularWaitDeadlock {
    public static void main(String[] args) {
        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread task1 = new Thread(()-> {
            while(!Thread.interrupted()) {
                synchronized (resource1){
                    System.out.println("task1 resource1 획득");
                    synchronized (resource2){
                        System.out.println("task1 resource2 획득");
                        System.out.println(resource1 + " , " + resource2);
                    }
                }
            }
        });

        Thread task2 = new Thread(()-> {
            while(!Thread.interrupted()) {
                synchronized (resource1){
                    System.out.println("task2 re2 획득");
                    synchronized (resource2){
                        System.out.println("task2 re1 획득");
                        System.out.println(resource1 + " , " + resource2);
                    }
                }
            }
        });

        task1.start();
        task2.start();
    }
}
