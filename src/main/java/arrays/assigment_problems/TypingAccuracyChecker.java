package arrays.assigment_problems;

import java.util.Locale;

/**
 * Problem 2: The Typing Speed Test Accuracy Checker
 *
 * Compares typed text against the original passage character by character,
 * computes accuracy percentage, and reports the position of the first mismatch.
 */
public class TypingAccuracyChecker {

    /**
     * Checks typing accuracy between original text and typed text.
     *
     * @param original the original passage
     * @param typed the text entered by user
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        int limit = Math.min(total, typed.length());
        for (int i = 0; i < limit; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-indexed position
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        // If lengths differ, any missing/extra character represents a mismatch
        if (firstMismatchPos == -1 && total != typed.length()) {
            firstMismatchPos = limit + 1;
            origChar = (limit < total) ? original.charAt(limit) : ' ';
            typedChar = (limit < typed.length()) ? typed.charAt(limit) : ' ';
        }

        double accuracy = (total == 0) ? 100.0 : ((double) matched / total) * 100.0;
        String formattedAccuracy = String.format(Locale.US, "%.2f%%", accuracy);

        if (firstMismatchPos == -1 && total == typed.length()) {
            System.out.println("Matched: " + matched + "/" + total + " | Accuracy: " + formattedAccuracy + " | No Mismatches");
        } else {
            System.out.println("Matched: " + matched + "/" + total + " | Accuracy: " + formattedAccuracy + 
                               " | First Mismatch at position " + firstMismatchPos + " ('" + origChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\n--- Test Case 2 ---");
        checkTypingAccuracy("coding", "coding");
    }
}
