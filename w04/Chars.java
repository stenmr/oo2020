package w04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Chars
 */
public class Chars {

    public static void main(String[] args) {

        final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        char[] textArray = text.toLowerCase().toCharArray();
        Map<Character, Integer> dict = new LinkedHashMap<Character, Integer>();

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i] == ch) {
                    int count;
                    if (dict.get(ch) != null) {
                        count = dict.get(ch) + 1;
                    } else {
                        count = 1;
                    }

                    dict.put(Character.valueOf(ch), Integer.valueOf(count));
                    break;
                }
            }
        }

        System.out.println(dict);
    }
}