import java.util.Arrays;

public class HackathonProblems {

    // PROBLEM 1: Hackathon Score Curve Booster
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
        System.out.println(Arrays.toString(scores));
    }

    // PROBLEM 2: Duplicate Team Name Finder
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    // PROBLEM 3: Top-3 Podium Finder
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }
        return new int[]{first, second, third};
    }

    // PROBLEM 4: Hackathon Seating Grid Optimizer
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";
            result.append("Row ").append(i).append(": ").append(zone);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    // PROBLEM 5: Placement Drive Shortlisting & Ranking Engine
    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;
        private final double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            this.compositeScore = cgpa * 10 + codingScore * 0.5;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore, this.compositeScore);
        }

        public String toString() {
            return String.format("%.1f", compositeScore);
        }

        public String getName() {
            return name;
        }

        public double getCompositeScore() {
            return compositeScore;
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) || Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count++] = c;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);
        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            result.append(i + 1).append(". ")
                  .append(finalList[i].getName())
                  .append(" (").append(finalList[i].getCompositeScore()).append(")");
            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test Problem 1
        System.out.println("=== Problem 1: Curve Scores ===");
        int[] scores1 = {70, 85, 60};
        curveScores(scores1, 10);

        // Test Problem 2
        System.out.println("\n=== Problem 2: Duplicate Team ===");
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teams1));
        System.out.println(findDuplicateTeam(teams2));

        // Test Problem 3
        System.out.println("\n=== Problem 3: Top 3 Scores ===");
        int[] scores3 = {45, 82, 79, 90, 33, 90, 61};
        int[] top3 = findTopThreeScores(scores3);
        System.out.println(Arrays.toString(top3));

        // Test Problem 4
        System.out.println("\n=== Problem 4: Classify Rows ===");
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seating, 60));

        // Test Problem 5
        System.out.println("\n=== Problem 5: Shortlist & Rank ===");
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}