package arrays_and_methods.assigment_problems;

/**
 * Problem 3: Top Performer Tracker (Intermediate Tier)
 *
 * Tracks the minimum score, maximum score, and their spread in a single pass
 * without sorting the array.
 */
public class TopPerformerTracker {

    /**
     * Finds min, max, and spread in a single pass.
     *
     * @param scores array of player scores (length >= 2)
     * @return formatted report string "Min: ... | Max: ... | Spread: ..."
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            return "Invalid score array";
        }

        int min = scores[0];
        int max = scores[0];

        // Single pass updating both min and max simultaneously
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
    }
}
