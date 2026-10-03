import java.util.Scanner;

public class Problem3_LibraryLateFine {

    abstract static class LibraryItem {
        protected final String title;
        protected final int daysLate;
        public LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
        public abstract double calculateFine();
        public String getTitle() { return title; }
    }

    static class Book extends LibraryItem {
        public Book(String title, int daysLate) { super(title, daysLate); }
        public double calculateFine() { return 2 * daysLate; }
    }

    static class DVD extends LibraryItem {
        public DVD(String title, int daysLate) { super(title, daysLate); }
        public double calculateFine() { return Math.min(5 * daysLate, 50); }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String title, int daysLate) { super(title, daysLate); }
        public double calculateFine() { return 1 * daysLate; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalFines = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item = switch (type) {
                case "BOOK" -> new Book(title, daysLate);
                case "DVD" -> new DVD(title, daysLate);
                case "MAGAZINE" -> new Magazine(title, daysLate);
                default -> null;
            };
            if (item != null) {
                double fine = item.calculateFine();
                totalFines += fine;
                System.out.printf("%s: %.2f%n", item.getTitle(), fine);
            }
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}