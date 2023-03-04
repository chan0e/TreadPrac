package codes;

import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class Store {
    int boxCount;
    Semaphore tickets;


    public Store() {
        boxCount = 10;
        this.tickets = new Semaphore(5);
    }

    public void enter() {
        try {
            tickets.acquire();
            System.out.println(Thread.currentThread().getName() + " 입장");
        } catch (InterruptedException ignore) {

        }


    }

    public void exit() {
        tickets.release();
        System.out.println(Thread.currentThread().getName() + " 퇴장");
    }

    public synchronized void buy() {
        // while (boxCount == 0) {
        if (boxCount == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " 구매대기");
                //구매대기
                wait();




            } catch (InterruptedException ignore) {

            }
        }
        --boxCount;
        System.out.println("구매완료, 제고 : " + boxCount);
        notify();
        //}
    }

    public synchronized void sell() {

        //while (boxCount >= 10) {
        if (boxCount == 10) {
            try {
                //납품대기
                System.out.println("납품대기..");
                wait();

            } catch (InterruptedException ignore) {

            }
        }
        ++boxCount;

        System.out.println("납품완료, 제고 : " + boxCount);
        notifyAll();
        //}
    }
}

