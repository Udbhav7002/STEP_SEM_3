import java.util.Scanner;

public class Problem3_DeliveryFeeCalculator {

    interface Delivery {
        double calculateFee();
        String getType();
    }

    static class StandardDelivery implements Delivery {
        private final double weight, distance;
        public StandardDelivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
        public double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
        public String getType() { return "STANDARD"; }
    }

    static class ExpressDelivery implements Delivery {
        private final double weight, distance;
        public ExpressDelivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
        public double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
        public String getType() { return "EXPRESS"; }
    }

    static class InternationalDelivery implements Delivery {
        private final double weight, distance, customsFee;
        public InternationalDelivery(double weight, double distance, double customsFee) {
            this.weight = weight; this.distance = distance; this.customsFee = customsFee;
        }
        public double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
        public String getType() { return "INTERNATIONAL"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery delivery = null;
            if (type.equals("INTERNATIONAL")) {
                double customsFee = sc.nextDouble();
                delivery = new InternationalDelivery(weight, distance, customsFee);
            } else if (type.equals("STANDARD")) {
                delivery = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                delivery = new ExpressDelivery(weight, distance);
            }
            if (delivery != null) {
                double fee = delivery.calculateFee();
                total += fee;
                System.out.printf("%s: %.2f%n", delivery.getType(), fee);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}