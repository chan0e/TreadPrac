package codes;

public class CounterRunnable implements Runnable {
    String name;
    int count;

    public CounterRunnable(String name) {
        this.name = name;
        count = 0;
    }

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