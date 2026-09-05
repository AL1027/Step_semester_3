package arrays_and_methods.assigment_problems;

/**
 * Problem 4: Match Day Grid Analyzer (Intermediate Tier)
 *
 * Analyzes cricket over-by-over runs recorded as a 2D grid (ragged array),
 * computes per-match averages via a reusable helper method, and classifies
 * each match as "Power Surge" or "Normal".
 */
public class MatchDayGridAnalyzer {

    /**
     * Private helper method that computes the average runs in an over row.
     *
     * @param row array representing runs in each over of a match
     * @return average run rate for the match
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies each match in the grid based on its average against the threshold.
     *
     * @param runsPerOver 2D array of runs per over (one row per match)
     * @param threshold scoring rate threshold for Power Surge
     * @return formatted classification string across all matches
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println(classifyMatches(runs, threshold));
    }
}
