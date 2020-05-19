package app;

public class CountAToK implements Runnable {

    public void run() {
        for(char i = 'a'; i <= 'k'; i++){
            System.out.println(i);
        }
    }
}