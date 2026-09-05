import java.util.*;

public class WordFrequencyReport {
    private static final Set<String> STOP_WORDS =
            new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

    public static void printFilteredWordFrequency(String feedback) {
        
        String cleaned = feedback.toLowerCase().replaceAll("[.,]", " ");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if (!STOP_WORDS.contains(w) && !w.isEmpty()) {
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }

        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
