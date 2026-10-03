import java.util.Scanner;

public class Problem1_MovieTicketCounter {

    abstract static class Ticket {
        protected final int count;
        protected static final double CONVENIENCE_FEE = 20;
        public Ticket(int count) { this.count = count; }
        public abstract double getPricePerTicket();
        public double calculateTotal() { return count * (getPricePerTicket() + CONVENIENCE_FEE); }
        public abstract String getType();
    }

    static class Regular extends Ticket {
        public Regular(int count) { super(count); }
        public double getPricePerTicket() { return 150; }
        public String getType() { return "REGULAR"; }
    }

    static class Premium extends Ticket {
        public Premium(int count) { super(count); }
        public double getPricePerTicket() { return 250; }
        public String getType() { return "PREMIUM"; }
    }

    static class Recliner extends Ticket {
        public Recliner(int count) { super(count); }
        public double getPricePerTicket() { return 400; }
        public String getType() { return "RECLINER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket ticket = switch (type) {
                case "REGULAR" -> new Regular(count);
                case "PREMIUM" -> new Premium(count);
                case "RECLINER" -> new Recliner(count);
                default -> null;
            };
            if (ticket != null) {
                double amount = ticket.calculateTotal();
                total += amount;
                System.out.printf("%s: %.2f%n", ticket.getType(), amount);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}