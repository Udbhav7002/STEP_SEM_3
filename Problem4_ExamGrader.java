import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Problem4_ExamGrader {

    interface Question {
        double grade();
        String getType();
    }

    static class MCQ implements Question {
        private final String correct, student;
        private final int points;
        public MCQ(String correct, String student, int points) {
            this.correct = correct; this.student = student; this.points = points;
        }
        public double grade() { return correct.equalsIgnoreCase(student) ? points : 0; }
        public String getType() { return "MCQ"; }
    }

    static class TF implements Question {
        private final String correct, student;
        private final int points;
        public TF(String correct, String student, int points) {
            this.correct = correct; this.student = student; this.points = points;
        }
        public double grade() { return correct.equalsIgnoreCase(student) ? points : 0; }
        public String getType() { return "TF"; }
    }

    static class Essay implements Question {
        private final String correct, student;
        private final int points;
        public Essay(String correct, String student, int points) {
            this.correct = correct; this.student = student; this.points = points;
        }
        public double grade() {
            String[] keywords = correct.toLowerCase().split(",\\s*");
            String studentLower = student.toLowerCase();
            int matches = 0;
            for (String kw : keywords) {
                if (studentLower.contains(kw)) matches++;
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.5;
            return 0;
        }
        public String getType() { return "ESSAY"; }
    }

    private static List<String> parseQuoted(String line) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < line.length()) {
            while (i < line.length() && line.charAt(i) == ' ') i++;
            if (i >= line.length()) break;
            if (line.charAt(i) == '"') {
                i++;
                int start = i;
                while (i < line.length() && line.charAt(i) != '"') i++;
                result.add(line.substring(start, i));
                if (i < line.length()) i++;
            } else {
                int start = i;
                while (i < line.length() && line.charAt(i) != ' ') i++;
                result.add(line.substring(start, i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            List<String> tokens = parseQuoted(line);
            String type = tokens.get(0);
            Question q = null;
            if (type.equals("MCQ") || type.equals("TF")) {
                String correct = tokens.get(2);
                String student = tokens.get(3);
                int points = Integer.parseInt(tokens.get(4));
                q = type.equals("MCQ") ? new MCQ(correct, student, points) : new TF(correct, student, points);
            } else if (type.equals("ESSAY")) {
                String correct = tokens.get(2);
                String student = tokens.get(3);
                int points = Integer.parseInt(tokens.get(4));
                q = new Essay(correct, student, points);
            }
            if (q != null) {
                double score = q.grade();
                total += score;
                System.out.printf("%s: %.2f%n", q.getType(), score);
            }
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}