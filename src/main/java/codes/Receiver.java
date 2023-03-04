package codes;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    Pipe pipe;

    public Receiver(Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Receive data: " + pipe.receive());
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
