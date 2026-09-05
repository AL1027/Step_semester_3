package arrays_and_methods.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Fantasy League Auto-Draft Ranking Engine (Advanced Tier)
 *
 * Implements overloaded draft qualification rules, encapsulated Player objects,
 * and natural ordering via Comparable<Player> and Arrays.sort().
 */
public class AutoDraftRankingEngine {

    /**
     * Encapsulated Player class implementing Comparable for natural descending ranking.
     */
    public static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        /**
         * Orders players descending by batting average (fantasy points).
         */
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        @Override
        public String toString() {
            return name + " (" + battingAverage + ")";
        }
    }

    /**
     * Overloaded draftable check for established players based on experience alone.
     *
     * @param matchesPlayed total matches played
     * @return true if player qualifies on experience alone (matches >= 10)
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded draftable check for newer players based on both matches and fitness.
     *
     * @param matchesPlayed total matches played
     * @param injured current injury status
     * @return true if player qualifies on combined rule (matches >= 5 and not injured)
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Filters draftable players, ranks them using Arrays.sort, and formats the leaderboard.
     *
     * @param players array of candidate players
     * @return formatted ranking string
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            // Established player rule OR combined fitness-and-experience rule
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        // Built-in sort using Comparable<Player> implementation
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append((i + 1)).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String ranking = draftAndRank(players);
        System.out.println(ranking);
    }
}
