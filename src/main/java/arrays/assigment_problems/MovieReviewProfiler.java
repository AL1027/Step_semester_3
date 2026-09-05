package arrays.assigment_problems;

/**
 * Problem 5: The Movie Review Word Length Profiler
 *
 * Moderation tool that profiles word lengths in reviews:
 * Short (1-4 letters), Medium (5-8 letters), Long (9+ letters).
 */
public class MovieReviewProfiler {

    /**
     * Classifies and counts word lengths in a given movie review string.
     *
     * @param review movie review text
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split by one or more whitespace characters
        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");

        System.out.println("\n--- Test Case 2 ---");
        classifyWordLengths("A great cinematic masterpiece with breathtaking visuals");
    }
}
