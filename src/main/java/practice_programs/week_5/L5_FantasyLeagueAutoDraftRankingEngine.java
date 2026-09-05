package practice_programs.week_5;

public class L5_FantasyLeagueAutoDraftRankingEngine {
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

        public static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        public static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.getBattingAverage(), this.getBattingAverage());
        }
    }

    public static String draftAndRank(Player[] players) {
        java.util.ArrayList<Player> draftable = new java.util.ArrayList<>();
        for (Player p : players) {
            boolean eligible;
            if (p.getMatchesPlayed() >= 10) {
                eligible = Player.isDraftable(p.getMatchesPlayed());
            } else {
                eligible = Player.isDraftable(p.getMatchesPlayed(), p.isInjured());
            }
            if (eligible) {
                draftable.add(p);
            }
        }

        Player[] draftableArray = draftable.toArray(new Player[0]);
        java.util.Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(draftableArray[i].getName());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}