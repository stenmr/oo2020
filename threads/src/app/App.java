package app;

public class App {
    public static void main(String[] args) throws Exception {
        Runnable[] runnables = {new CountUp(), new CountDown(), new CountAToK(), new CountKToA()};

        for (Runnable runnable : runnables) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}