import java.util.Scanner;

public class Problem4_ElectricityBilling {

    abstract static class Connection {
        protected final int units;
        public Connection(int units) { this.units = units; }
        public abstract double calculateBill();
    }

    static class Home extends Connection {
        public Home(int units) { super(units); }
        public double calculateBill() {
            if (units <= 100) return 5 * units;
            return 5 * 100 + 7 * (units - 100);
        }
    }

    static class Shop extends Connection {
        public Shop(int units) { super(units); }
        public double calculateBill() { return 8 * units + 100; }
    }

    static class Factory extends Connection {
        public Factory(int units) { super(units); }
        public double calculateBill() { return Math.max(6 * units, 1000); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection conn = switch (type) {
                case "HOME" -> new Home(units);
                case "SHOP" -> new Shop(units);
                case "FACTORY" -> new Factory(units);
                default -> null;
            };
            if (conn != null) {
                double bill = conn.calculateBill();
                total += bill;
                System.out.printf("%s: %.2f%n", type, bill);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}