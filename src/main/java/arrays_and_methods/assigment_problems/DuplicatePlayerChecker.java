package arrays_and_methods.assigment_problems;

/**
 * Problem 2: Duplicate Player Pick Checker (Easy Tier)
 *
 * Checks a submitted lineup for repeated player names using plain nested loops
 * and early-exit scanning without any Collections classes.
 */
public class DuplicatePlayerChecker {

    /**
     * Finds the first duplicated player pick in the lineup.
     *
     * @param playerNames array of player name strings
     * @return message indicating the first duplicate found, or confirmation of no duplicates
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length <= 1) {
            return "No Duplicates Found";
        }

        // Pairwise comparison using plain nested loops
        for (int i = 0; i < playerNames.length; i++) {
            if (playerNames[i] == null) {
                continue;
            }
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1));

        System.out.println("\n--- Test Case 2 ---");
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(lineup2));
    }
}
