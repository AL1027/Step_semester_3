package arrays_and_methods.assigment_problems;

public class DuplicatePlayerChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length <= 1) {
            return "No Duplicates Found";
        }

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
