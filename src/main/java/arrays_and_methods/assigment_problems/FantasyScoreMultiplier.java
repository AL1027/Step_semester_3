package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Problem 1: Fantasy Team Score Multiplier (Easy Tier)
 *
 * Directly applies score multipliers (Captain: 2x, Vice-Captain: 1.5x)
 * to the original array without returning a new array.
 */
public class FantasyScoreMultiplier {

    /**
     * Applies multipliers directly to the caller's score array.
     *
     * @param playerScores array of player scores passed by reference
     * @param captainIndex index of captain to receive 2x multiplier
     * @param viceCaptainIndex index of vice-captain to receive 1.5x multiplier
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null || captainIndex < 0 || captainIndex >= playerScores.length
                || viceCaptainIndex < 0 || viceCaptainIndex >= playerScores.length) {
            return;
        }

        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        double[] scores = {40, 55, 30, 62};
        System.out.println("Before: " + Arrays.toString(scores));
        applyMultipliers(scores, 1, 3);
        System.out.println("After:  " + Arrays.toString(scores));
    }
}
