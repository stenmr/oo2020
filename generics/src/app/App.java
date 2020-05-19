package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        HomemadeMap homemadeMap = new HomemadeMap<String, String>("hello", "goodbye");
        System.out.println(homemadeMap.getValue());
    }
}