package w03_klassikomplekt;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        LinkedHashSet<String> set = new LinkedHashSet<String>();

        List<Integer> populatedList = populateArray(list, 50, 20);
        System.out.println(populatedList);

        LinkedHashSet<String> populatedSet = populateSet(set, 50, 8);
        System.out.println(populatedSet);
    }

    private static List<Integer> populateArray(List<Integer> list, int amount, int max) {

        Random r = new Random();

        for (int i = 0; i < amount; i++) {
            int randomNumber = r.nextInt(max);

            list.add(randomNumber);
        }

        return list;
    }

    public static LinkedHashSet<String> populateSet(LinkedHashSet<String> set, int amount, int length) {

        final char[] vowels = "aeiou".toCharArray();
        final char[] consonants = "bcdfghjklmnpqrstvwxyz".toCharArray();

        Random r = new Random();

        for (int i = 0; i < amount; i++) {

            char[] word = new char[length];

            for (int j = 0; j < length; j++) {

                boolean choice = r.nextBoolean();
                int randomNumber;
                char prev = 0;
                int state = 0;

                if (j != 0) {
                    for (int k = word.length; k > 0; k--) {
                        if (word[k - 1] != '\u0000') {
                            prev = word[k - 1];
                            break;
                        }
                    }
                }
            
                if (prev != 0) {
                    for (char c : vowels) {
                        if (c == prev) {
                            state = 1;
                        }
                    }

                    for (char c : consonants) {
                        if (c == prev) {
                            state = 2;
                        }
                    }
                }

                if (state == 2) {
                    choice = true;
                } else {
                    choice = false;
                }
                if (choice) {
                    randomNumber = r.nextInt(vowels.length);
                } else {
                    randomNumber = r.nextInt(consonants.length);
                }

                word[j] = choice ? vowels[randomNumber] : consonants[randomNumber];                
            }

            set.add(String.copyValueOf(word));

        }
        return set;
    }
}