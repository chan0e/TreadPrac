package codes;

public class CountAgent extends  Thread{

    final Counter counter;
    int numberofIterations;
    boolean increment;

    public CountAgent(Counter counter, int numberofIterations, boolean increment) {
        super();
        this.counter = counter;
        this.numberofIterations = numberofIterations;
        this.increment = increment;
    }

    @Override
    public void run(){
        for(int i = 0 ; i < numberofIterations; i++){
            if(increment){
                counter.increment();
            }else{
                counter.decrement();
            }
        }
    }
}
