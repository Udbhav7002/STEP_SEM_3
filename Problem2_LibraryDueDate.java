import java.time.LocalDate;
import java.util.Scanner;

public class Problem2_LibraryDueDate {

    interface LibraryItem {
        String getTitle();
        LocalDate calculateDueDate(LocalDate currentDate);
    }

    static class Book implements LibraryItem {
        private final String title;
        public Book(String title) { this.title = title; }
        public String getTitle() { return title; }
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
    }

    static class DVD implements LibraryItem {
        private final String title;
        public DVD(String title) { this.title = title; }
        public String getTitle() { return title; }
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
    }

    static class Magazine implements LibraryItem {
        private final String title;
        public Magazine(String title) { this.title = title; }
        public String getTitle() { return title; }
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int spaceIdx = line.indexOf(' ');
            String type = line.substring(0, spaceIdx);
            String title = line.substring(spaceIdx + 1).replace("\"", "");
            LibraryItem item = switch (type) {
                case "BOOK" -> new Book(title);
                case "DVD" -> new DVD(title);
                case "MAGAZINE" -> new Magazine(title);
                default -> null;
            };
            if (item != null) {
                LocalDate dueDate = item.calculateDueDate(currentDate);
                System.out.printf("%s: %s%n", item.getTitle(), dueDate);
            }
        }
        sc.close();
    }
}