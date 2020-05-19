package app;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class App {
    final static String CURRENT_DIR = System.getProperty("user.dir");
    final static String PATH_TO_TEXT = Path.of(CURRENT_DIR + "/text.txt").toAbsolutePath().toString();
    final static Path OUTPUT_PATH = Path.of(CURRENT_DIR + "/index.html");
    final static Pattern DELIMITER = Pattern.compile("[\\s.,_-]");

    public static void main(String[] args) throws Exception {

        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        Scanner in = new Scanner(new FileReader(PATH_TO_TEXT));
        in.useDelimiter(DELIMITER);

        while (in.hasNext()) {
            String word = in.next().toLowerCase();
            if (word.length() != 0) {
                String lastChar = word.substring(word.length() - 1);

                hashMap.putIfAbsent(lastChar, new ArrayList<String>());
                hashMap.get(lastChar).add(word);
            }
        }

        in.close();

        LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<String, List<String>>(
                sortHashMap(hashMap));

        linkedHashMap.forEach((k, v) -> System.out.println(k + ": " + v.size()));

        writeToFiles(linkedHashMap);
        String link = htmlBuilder(linkedHashMap);

        System.out.println(link);
    }

    // Mõistlik? Kindlasti mitte aga see töötab
    private static LinkedHashMap<String, List<String>> sortHashMap(HashMap<String, List<String>> hashMap) {

        // Meil on vaja ise kirjutada comparator et sorteerida hashmap väärtuste järgi,
        // minu puhul listi suuruse järgi
        Comparator<Entry<String, List<String>>> valueComparator = new Comparator<Entry<String, List<String>>>() {

            @Override
            public int compare(Entry<String, List<String>> e1, Entry<String, List<String>> e2) {
                int v1 = e1.getValue().size();
                int v2 = e2.getValue().size();
                if (v1 == v2)
                    return 0;
                else if (v1 > v2)
                    return -1;
                else
                    return 1;
            }
        };

        // Unpackime siis hashMapi, sorteerime ära, ning ehitame uuesti üles LinkedHashMapina mis hoiab sisestusjärjekorda
        Set<Entry<String, List<String>>> entries = hashMap.entrySet();

        List<Entry<String, List<String>>> listOfEntries = new ArrayList<Entry<String, List<String>>>(entries);

        Collections.sort(listOfEntries, valueComparator);

        LinkedHashMap<String, List<String>> sortedByValue = new LinkedHashMap<String, List<String>>(
                listOfEntries.size());

        for (Entry<String, List<String>> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        return sortedByValue;
    }

    private static void writeToFiles(HashMap<String, List<String>> hashMap) {

        for (Entry<String, List<String>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            List<String> array = entry.getValue();

            StringBuilder sb = new StringBuilder();
            for (String string : array) {
                sb.append(string + " ");
            }

            try {
                Files.write(Path.of(CURRENT_DIR + "/" + key + ".txt"), sb.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String htmlBuilder(HashMap<String, List<String>> hashMap) {
        StringBuilder sb = new StringBuilder();

        sb.append("<!DOCTYPE html>\n<html>\n<body>\n<h1>Levinumad tähed antud tekstis</h1>\n<ul>\n");

        for (Entry<String, List<String>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            List<String> array = entry.getValue();
            sb.append("<li><a href=\"" + key + ".txt\">" + key + "</a> - " + array.size() + "</li>\n");
        }
        sb.append("</ul>\n</body>\n</html>");

        try {
            Files.write(OUTPUT_PATH, sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Salvestatud: " + OUTPUT_PATH.toAbsolutePath().toString();
    }
}