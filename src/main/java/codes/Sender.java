package codes;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {

    Pipe pipe;

    public Sender(Pipe pipe) {
        this.pipe = pipe;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                //랜덤 난수가 보내짐
                pipe.send(ThreadLocalRandom.current().nextInt());

                //1000 ~ 5000 사이 랜덤으로 sleep
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
