package codes;

public class Counter {
    int count;
    int anothercount;

    public Counter() {
        this.count = 0;
        this.anothercount = 0;
    }

    public  void increment() {
        synchronized(this){

            count++;
        }

        anothercount++;
    }

    public synchronized void decrement() {
        synchronized(this){

            count--;
        }
        anothercount--;
    }

    public long getCount() {
        return count;
    }

    public long getanotherCount() {
        return anothercount;
    }


}
