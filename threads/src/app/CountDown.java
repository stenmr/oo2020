package app;

public class CountDown implements Runnable {

    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}