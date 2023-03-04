package org.example;

import codes.CounterRunnable;

public class counterRunnableTest {
    public static void main(String[] args) {
        CounterRunnable counterRunnable = new CounterRunnable("CounterRunnable");
        Thread thread = new Thread(counterRunnable);

        thread.start();

    }
}