public class Problem6_ClassAttendanceTracker {

    static class ClassAttendanceTracker {
        public int[] attendanceSummary(int[] days) {
            int present = 0;
            int longestStreak = 0;
            int currentStreak = 0;
            for (int d : days) {
                if (d == 1) {
                    present++;
                    currentStreak++;
                    if (currentStreak > longestStreak) longestStreak = currentStreak;
                } else {
                    currentStreak = 0;
                }
            }
            return new int[]{present, longestStreak};
        }
    }

    public static void main(String[] args) {
        ClassAttendanceTracker tracker = new ClassAttendanceTracker();
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] res1 = tracker.attendanceSummary(days1);
        System.out.println("Present: " + res1[0] + ", Longest streak: " + res1[1]); // Expected: 6, 3
        int[] days2 = {0, 0, 0};
        int[] res2 = tracker.attendanceSummary(days2);
        System.out.println("Present: " + res2[0] + ", Longest streak: " + res2[1]); // Expected: 0, 0
        System.out.println("---");
        int[] days3 = {1, 1, 1, 1};
        int[] res3 = tracker.attendanceSummary(days3);
        System.out.println("Present: " + res3[0] + ", Longest streak: " + res3[1]); // Expected: 4, 4
        int[] days4 = {1, 0, 1, 0, 1};
        int[] res4 = tracker.attendanceSummary(days4);
        System.out.println("Present: " + res4[0] + ", Longest streak: " + res4[1]); // Expected: 3, 1
    }
}