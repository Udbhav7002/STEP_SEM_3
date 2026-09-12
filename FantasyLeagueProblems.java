import java.util.Arrays;

public class FantasyLeagueProblems {

    // PROBLEM 1: Fantasy Team Score Multiplier
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
        System.out.println(Arrays.toString(playerScores));
    }

    // PROBLEM 2: Duplicate Player Pick Checker
    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    // PROBLEM 3: Top Performer Tracker
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        
        for (int score : scores) {
            if (score < min) min = score;
            if (score > max) max = score;
        }
        
        return String.format("Min: %d | Max: %d | Spread: %d", min, max, max - min);
    }

    // PROBLEM 4: Match Day Grid Analyzer
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";
            result.append("Match ").append(i).append(": ").append(classification);
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    // PROBLEM 5: Fantasy League Auto-Draft Ranking Engine
    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;
        private final double fantasyPoints;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
            this.fantasyPoints = battingAverage * 10 + matchesPlayed * 2;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.fantasyPoints, this.fantasyPoints);
        }

        public String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count++] = p;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);
        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            result.append(i + 1).append(". ").append(finalList[i].getName());
            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test Problem 1
        System.out.println("=== Problem 1: Apply Multipliers ===");
        double[] scores1 = {40, 55, 30, 62};
        applyMultipliers(scores1, 1, 3);

        // Test Problem 2
        System.out.println("\n=== Problem 2: Duplicate Pick ===");
        String[] names1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String[] names2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(names1));
        System.out.println(findDuplicatePick(names2));

        // Test Problem 3
        System.out.println("\n=== Problem 3: Min Max Spread ===");
        int[] scores3 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores3));

        // Test Problem 4
        System.out.println("\n=== Problem 4: Classify Matches ===");
        int[][] matches = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(matches, 8));

        // Test Problem 5
        System.out.println("\n=== Problem 5: Draft and Rank ===");
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}