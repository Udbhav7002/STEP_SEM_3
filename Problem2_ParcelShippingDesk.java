import java.util.Scanner;

public class Problem2_ParcelShippingDesk {

    interface Insurable {
        double calculateInsurance();
    }

    abstract static class Parcel {
        protected final double weight, declaredValue;
        public Parcel(double weight, double declaredValue) { this.weight = weight; this.declaredValue = declaredValue; }
        public abstract double calculateCharge();
        public double calculateInsurance() { return 0; }
        public double calculateTotal() { return calculateCharge() + calculateInsurance(); }
        public abstract String getType();
    }

    static class StandardParcel extends Parcel {
        public StandardParcel(double weight, double declaredValue) { super(weight, declaredValue); }
        public double calculateCharge() { return 40 + 10 * weight; }
        public String getType() { return "STANDARD"; }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weight, double declaredValue) { super(weight, declaredValue); }
        public double calculateCharge() { return 80 + 15 * weight; }
        public double calculateInsurance() { return 0.02 * declaredValue; }
        public String getType() { return "EXPRESS"; }
    }

    static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weight, double declaredValue) { super(weight, declaredValue); }
        public double calculateCharge() { return (40 + 10 * weight) + 50; }
        public double calculateInsurance() { return 0.02 * declaredValue; }
        public String getType() { return "FRAGILE"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();
            Parcel parcel = switch (type) {
                case "STANDARD" -> new StandardParcel(weight, declaredValue);
                case "EXPRESS" -> new ExpressParcel(weight, declaredValue);
                case "FRAGILE" -> new FragileParcel(weight, declaredValue);
                default -> null;
            };
            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double insurance = parcel.calculateInsurance();
                double total = parcel.calculateTotal();
                grandTotal += total;
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", parcel.getType(), charge, insurance, total);
            }
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}