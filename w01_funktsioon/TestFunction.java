package w01_funktsioon;

public class TestFunction {
    public static void main(String[] args) {

        String horizontal = new String();

        for (int i = 1; i < 11; i++) {
            horizontal += i + " ";
        }

        System.out.println(horizontal);
        
        for (int i = 1; i < 11; i++) {
            String multiplication = new String();

            for (int j = 1; j < 11; j++) {
                if (j == 1) {
                    multiplication += i + " ";
                }
                multiplication += i * j + " ";
            }
            System.out.println(multiplication);
        }

    }
}