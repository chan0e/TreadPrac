package codes;

public class Pipe {

    private int data;

    private boolean empty;

    public Pipe(){
        data = 0 ;
        empty = true;
    }

    //synchronized
    public synchronized int receive() throws InterruptedException{
        while(empty){
            try {
                wait();

                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw e;
            }
        }
        empty = true;
        notify();

        return  data;

    }

    public synchronized  void send(int data) throws  InterruptedException{
        while(!empty){
            try {
                wait();
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw e;
            }
        }



        this.data = data;
        this.empty = false;

        //wait후 깨어나게함 notify()는 하나의 스레드만 깨운다
        //notifyall()은 모든 스레드를 깨운다.
        notify();

    }

}
