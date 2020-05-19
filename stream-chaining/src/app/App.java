package app;

import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        Random random = new Random();
        int[] ints = new int[50];

        for (int i = 0; i < ints.length; i++) {
            int value = random.nextInt(300);
            if (random.nextBoolean())
                value -= 299;
            ints[i] = value;
        }

        int result = IntStream.of(ints).map(i -> i * 3 + 1).reduce((int1, int2) -> int2 < 0 ? int1 + int2 : int2).getAsInt();

        System.out.println(result);
    }
}