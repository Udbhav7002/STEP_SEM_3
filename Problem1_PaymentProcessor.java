import java.util.Scanner;

public class Problem1_PaymentProcessor {

    interface Payment {
        double calculateAdjustedAmount();
        String getType();
    }

    static class CardPayment implements Payment {
        private final double amount;
        public CardPayment(double amount) { this.amount = amount; }
        public double calculateAdjustedAmount() { return amount * 1.02; }
        public String getType() { return "CARD"; }
    }

    static class WalletPayment implements Payment {
        private final double amount;
        public WalletPayment(double amount) { this.amount = amount; }
        public double calculateAdjustedAmount() { return amount * 1.01; }
        public String getType() { return "WALLET"; }
    }

    static class BankTransferPayment implements Payment {
        private final double amount;
        public BankTransferPayment(double amount) { this.amount = amount; }
        public double calculateAdjustedAmount() { return amount; }
        public String getType() { return "BANKTRANSFER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment = switch (type) {
                case "CARD" -> new CardPayment(amount);
                case "WALLET" -> new WalletPayment(amount);
                case "BANKTRANSFER" -> new BankTransferPayment(amount);
                default -> null;
            };
            if (payment != null) {
                double adjusted = payment.calculateAdjustedAmount();
                total += adjusted;
                System.out.printf("%s: %.2f%n", payment.getType(), adjusted);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}