import java.util.Scanner;

public class Problem5_TravelBooking {

    abstract static class Booking {
        protected final double distance;
        protected static final double BOOKING_FEE = 50;
        public Booking(double distance) { this.distance = distance; }
        public abstract double calculateBaseFare();
        public double calculateTotalFare() { return calculateBaseFare() + BOOKING_FEE; }
        public abstract String getMode();
    }

    static class Bus extends Booking {
        public Bus(double distance) { super(distance); }
        public double calculateBaseFare() { return 2 * distance; }
        public String getMode() { return "BUS"; }
    }

    static class Train extends Booking {
        public Train(double distance) { super(distance); }
        public double calculateBaseFare() { return 1.5 * distance; }
        public String getMode() { return "TRAIN"; }
    }

    static class Flight extends Booking {
        public Flight(double distance) { super(distance); }
        public double calculateBaseFare() { return 2500 + 4 * distance; }
        public String getMode() { return "FLIGHT"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking = switch (mode) {
                case "BUS" -> new Bus(distance);
                case "TRAIN" -> new Train(distance);
                case "FLIGHT" -> new Flight(distance);
                default -> null;
            };
            if (booking != null) {
                double total = booking.calculateTotalFare();
                System.out.printf("%s: %.2f%n", booking.getMode(), total);
            }
        }
        sc.close();
    }
}