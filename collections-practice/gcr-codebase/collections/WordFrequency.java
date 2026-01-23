import java.util.*;

public class WordFrequency {

    public static Map<String, Integer> countWords(String text) {

        Map<String, Integer> freqMap = new HashMap<>();

        // remove punctuation & convert to lowercase
        String[] words = text
                .toLowerCase()
                .replaceAll("[^a-z ]", "")
                .split("\\s+");

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        return freqMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println(countWords(input));
    }
}
