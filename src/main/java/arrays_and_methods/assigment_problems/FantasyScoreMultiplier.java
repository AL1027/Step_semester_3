package arrays_and_methods.assigment_problems;

import java.util.Arrays;

public class FantasyScoreMultiplier {

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
