import java.util.Scanner;

public class Problem2_ParkingCharge {

    interface Vehicle {
        double calculateCharge(int hours);
        String getType();
    }

    static class Bike implements Vehicle {
        public double calculateCharge(int hours) { return 10 * hours; }
        public String getType() { return "BIKE"; }
    }

    static class Car implements Vehicle {
        public double calculateCharge(int hours) {
            if (hours <= 1) return 30;
            return 30 + 20 * (hours - 1);
        }
        public String getType() { return "CAR"; }
    }

    static class Truck implements Vehicle {
        public double calculateCharge(int hours) { return Math.max(50 * hours, 100); }
        public String getType() { return "TRUCK"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle = switch (type) {
                case "BIKE" -> new Bike();
                case "CAR" -> new Car();
                case "TRUCK" -> new Truck();
                default -> null;
            };
            if (vehicle != null) {
                double charge = vehicle.calculateCharge(hours);
                total += charge;
                System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}