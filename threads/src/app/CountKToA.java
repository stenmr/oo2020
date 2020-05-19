package app;

public class CountKToA implements Runnable {

    public void run() {
        for(char i = 'k'; i >= 'a'; i--){
            System.out.println(i);
        }
    }
}