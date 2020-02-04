package w01_funktsioon;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.print("Hello World");

        byte myByte = Byte.MIN_VALUE;
        // byte, short, int, long, float, double, char, boolean

        boolean flag = true;

        System.out.println(1 + 1);
        int number = 5;
        if (number < 6 && number > 0) {
            System.out.println("Jah");
        }

        for (int i = 0; i < 10; i++) {

        }

        while (flag) {
            number++;
            if (number == 10) {
                System.out.println("I'm out");
                flag = false;
            }
        }

        int[] numberArray = new int[] {1, 2, 3, 4, 5};

        for(int element : numberArray) {
            System.out.println(element);
        }

        for (int i = 0; i < numberArray.length; i++) {
            System.out.println(numberArray[i]);
        }

        String myName = "Sten";

        System.out.println(myName);

        printSum(5);


        String name = name();
        System.out.println(name);
    }

    static String name() {
        return "Sten";
    }

    
    static void printSum(int number) {
        int sum = 0;
        for (; number < number + 20; number++) {
            sum = sum + number;
        }
        System.out.println(sum);
    }
}