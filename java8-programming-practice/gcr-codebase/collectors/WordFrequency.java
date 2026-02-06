import java.util.*;
import java.util.stream.*;

public class WordFrequency {

    public static void main(String args[]) {

        String paragraph = "java is easy java is powerful java";

        Map<String, Integer> map =
                Arrays.stream(paragraph.split(" "))
                        .collect(Collectors.toMap(
                                word -> word,
                                word -> 1,
                                Integer::sum
                        ));

        System.out.println(map);
    }
}
