package org.example;

import codes.CounterThread;

public class counterThreadTest {
    public static void main(String[] args) {
        CounterThread counter1 = new CounterThread("count1");
        CounterThread counter2 = new CounterThread("count2");

        counter1.setDaemon(true);
        counter1.start();
        //counter2.start();


    }
}