package org.example;

import codes.Counter;
import codes.CountAgent;
public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numberOfIterations = 10000;

        CountAgent agent1 = new CountAgent(counter, numberOfIterations, true);
        CountAgent agent2 = new CountAgent(counter, numberOfIterations, false);

        long starttime = System.currentTimeMillis();
        agent1.start();
        agent2.start();

        try {
            agent1.join();
            agent2.join();
        } catch(InterruptedException ignore) {
        }

        long endtime = System.currentTimeMillis() - starttime;

        System.out.println("Count : " + counter.getCount() + " 수행시간 >> " + endtime );
        System.out.println("antherCount : " + counter.getanotherCount() + " 수행시간 >> ");
    }
}
