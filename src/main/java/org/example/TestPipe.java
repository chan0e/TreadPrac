package org.example;

import codes.Pipe;
import codes.Receiver;
import codes.Sender;

public class TestPipe {

    public static void main(String[] args) {
        Pipe pipe = new Pipe();
        Sender sender = new Sender(pipe);
        Receiver receiver = new Receiver(pipe);

        Thread senderThread = new Thread(sender);
        Thread receiverThread = new Thread(receiver);


        //상태는 내부에서 볼수없고 외부에서 볼수있다.
        //반면 Running 상태는 스레드 내부에서 볼수 있다.

        System.out.println("Sender : " + senderThread.getState());
        System.out.println("receiver : " + receiverThread.getState());
        senderThread.start();
        receiverThread.start();

        while (!Thread.interrupted()) {
            try {
                System.out.print("Sender : " + senderThread.getState() + " ");
                System.out.println("receiver : " + receiverThread.getState());
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }

        }
    }
}
