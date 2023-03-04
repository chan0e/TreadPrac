package codes;

public class CounterThread extends Thread {
    String name;
    int count;

    public CounterThread(String name) {
        this.name = name;
        count = 0;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
                count++;
                System.out.println(name + " " + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}