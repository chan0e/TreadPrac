package codes;

import java.util.concurrent.ThreadLocalRandom;

public class Buyer extends Thread {
    Store store;

    public Buyer(String name, Store store) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {

        while (!Thread.interrupted()) {
            try {
                store.enter();
                store.buy();
                store.exit();
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 15000));
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }

        }

    }
}