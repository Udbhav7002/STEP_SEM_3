public class Problem9_LeapYearDetector {

    static class LeapYearDetector {
        public void check(int year) {
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(isLeap ? "Leap year" : "Not a leap year");
        }
    }

    public static void main(String[] args) {
        LeapYearDetector detector = new LeapYearDetector();
        detector.check(2024);
        detector.check(1900);
        detector.check(2000);
        System.out.println("---");
        detector.check(2023);
        detector.check(2020);
        detector.check(2100);
    }
}