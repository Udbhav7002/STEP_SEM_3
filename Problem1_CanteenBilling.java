import java.util.Scanner;

public class Problem1_CanteenBilling {

    interface Customer {
        double calculateFinalAmount(double amount);
        String getType();
    }

    static class Student implements Customer {
        public double calculateFinalAmount(double amount) { return amount * 0.90; }
        public String getType() { return "STUDENT"; }
    }

    static class Staff implements Customer {
        public double calculateFinalAmount(double amount) { return amount * 0.95; }
        public String getType() { return "STAFF"; }
    }

    static class Guest implements Customer {
        public double calculateFinalAmount(double amount) { return amount + 10; }
        public String getType() { return "GUEST"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer = switch (type) {
                case "STUDENT" -> new Student();
                case "STAFF" -> new Staff();
                case "GUEST" -> new Guest();
                default -> null;
            };
            if (customer != null) {
                double finalAmount = customer.calculateFinalAmount(amount);
                total += finalAmount;
                System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}