package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {

        String[] words = sentence.split(" ");
        Map<String, Integer> map = new HashMap<>();

        if (sentence.isEmpty()) {
            return map;
        }

        for (String word : words) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }
        return map;
    }

    public static String toString(Map<String, Integer> wordsCount) {

        if (wordsCount.isEmpty()) {
            return "{}";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        result.append("{\n");
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            result.append("  ").append(entry.getKey()).append(": ").append(entry.getValue());
            if (i < wordsCount.size() - 1) {
                result.append("\n");
            } else {
                result.append("\n}");
            }
            i++;
        }
        return result.toString();
    }
}
//END
