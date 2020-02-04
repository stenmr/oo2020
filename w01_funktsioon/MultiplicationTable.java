package w01_funktsioon;

public class MultiplicationTable {
    public static void main(String[] args) {
        
        for (int i = 1; i < 11; i++) {
            String line = new String();

            for (int j = 1; j < 11; j++) {

                int mult = i * j;

                String formatted = new String(format(mult, 4));

                line += formatted;
            }
            System.out.println(line);
        }

    }

    static String format(int number, int maxPadding) {

        int length = String.valueOf(number).length();
        int necessaryPadding = maxPadding - length;

        char paddingArray[] = new char[necessaryPadding];

        for (int i = 0; i < necessaryPadding; i++) {
            paddingArray[i] = ' ';
        }
        String paddingStr = new String(paddingArray);

        return paddingStr + number;
    }
}