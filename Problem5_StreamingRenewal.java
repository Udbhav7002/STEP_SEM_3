import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problem5_StreamingRenewal {

    interface Plan {
        LocalDate calculateRenewalDate(LocalDate startDate);
        String getName();
    }

    static class Basic implements Plan {
        private final String name;
        public Basic(String name) { this.name = name; }
        public LocalDate calculateRenewalDate(LocalDate startDate) { return startDate.plusDays(30); }
        public String getName() { return name; }
    }

    static class Standard implements Plan {
        private final String name;
        public Standard(String name) { this.name = name; }
        public LocalDate calculateRenewalDate(LocalDate startDate) { return startDate.plusDays(90); }
        public String getName() { return name; }
    }

    static class Premium implements Plan {
        private final String name;
        public Premium(String name) { this.name = name; }
        public LocalDate calculateRenewalDate(LocalDate startDate) { return startDate.plusDays(365); }
        public String getName() { return name; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr, fmt);
            Plan plan = switch (type) {
                case "BASIC" -> new Basic(name);
                case "STANDARD" -> new Standard(name);
                case "PREMIUM" -> new Premium(name);
                default -> null;
            };
            if (plan != null) {
                LocalDate renewal = plan.calculateRenewalDate(startDate);
                System.out.printf("%s: %s%n", plan.getName(), renewal.format(fmt));
            }
        }
        sc.close();
    }
}