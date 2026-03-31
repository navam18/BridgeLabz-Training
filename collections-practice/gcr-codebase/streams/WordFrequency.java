package streams;

import java.io.*;
import java.util.*;

class WordFrequency {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String w : words) {
                    if (!w.isEmpty())
                        map.put(w, map.getOrDefault(w, 0) + 1);
                }
            }

            map.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .limit(5)
                    .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        } catch (IOException e) {
            System.out.println("File error.");
        }
    }
}
