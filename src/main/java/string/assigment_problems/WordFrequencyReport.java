package string.assigment_problems;

import java.util.*;

/**
 * Problem 5: Stop-Word-Filtered Word Frequency Report
 *
 * Analyzes feedback paragraphs by stripping punctuation, filtering out common filler words,
 * counting unique word occurrences, and reporting results sorted by frequency descending.
 */
public class WordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
    ));

    /**
     * Normalizes text, filters stop words, and prints descending word frequency report.
     *
     * @param feedback feedback paragraph to analyze
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Normalize: convert to lowercase and strip punctuation using replace()
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "")
                                 .replace("!", "")
                                 .replace("?", "")
                                 .replace(";", "")
                                 .replace(":", "");

        // Split into words using whitespace pattern
        String[] words = cleaned.trim().split("\\s+");

        // Count frequencies in a HashMap
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> {
            int comp = b.getValue().compareTo(a.getValue());
            if (comp != 0) {
                return comp;
            }
            return a.getKey().compareTo(b.getKey());
        });

        // Print results
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
