package foundation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    // # 1  Write a function that takes any string as a parameter and returns me a map where
    //      there is always a word - word frequency in the text. For example:

    // # 2  Modify the given function so that I can specify a frequency as a second parameter and
    // the method will return a map with the given frequency only.

    public static void main(String[] args) {
        String sentence = "This is realy very very nice sentence, it is realy good for practice!'";

        // # Step 1
        System.out.println(wordCount(sentence));

        // # Step 2
        System.out.println(wordCount(sentence, 2));
    }

    public static Map<String, Integer> wordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : sentence.split("[,. !']")) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + 1);
            } else if (word.length() != 0){
                map.put(word, 1);
            }
        }
        return map;
    }

    public static Map<String, Integer> wordCount(String sentence, int frequency) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : sentence.split("[,. !']")) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + 1);
            } else if (word.length() != 0){
                map.put(word, 1);
            }
        }

        List<String> listOfKeys = new ArrayList<>();
        for (Map.Entry word : map.entrySet()) {
            if (word.getValue() != (Integer)frequency) {
                listOfKeys.add(String.valueOf(word.getKey()));
            }
        }
        for (String s : listOfKeys) {
            map.remove(s);
        }
        return map;
    }
}
