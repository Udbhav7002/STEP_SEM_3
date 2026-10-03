import java.util.Scanner;

public class Problem4_CityCabFareMeter {

    interface NightService {
        boolean supportsNightService();
    }

    abstract static class Cab {
        protected final double distance;
        protected final boolean isNight;
        protected static final double MIN_FARE = 100;
        protected static final double NIGHT_SURCHARGE = 0.20;
        public Cab(double distance, boolean isNight) { this.distance = distance; this.isNight = isNight; }
        public abstract double getRatePerKm();
        public double calculateFare() {
            double fare = distance * getRatePerKm();
            fare = Math.max(fare, MIN_FARE);
            if (isNight && supportsNightService()) {
                fare *= (1 + NIGHT_SURCHARGE);
            }
            return fare;
        }
        public boolean supportsNightService() { return false; }
        public abstract String getType();
    }

    static class Mini extends Cab {
        public Mini(double distance, boolean isNight) { super(distance, isNight); }
        public double getRatePerKm() { return 10; }
        public String getType() { return "MINI"; }
    }

    static class Sedan extends Cab implements NightService {
        public Sedan(double distance, boolean isNight) { super(distance, isNight); }
        public double getRatePerKm() { return 14; }
        public boolean supportsNightService() { return true; }
        public String getType() { return "SEDAN"; }
    }

    static class SUV extends Cab implements NightService {
        public SUV(double distance, boolean isNight) { super(distance, isNight); }
        public double getRatePerKm() { return 18; }
        public boolean supportsNightService() { return true; }
        public String getType() { return "SUV"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            String time = sc.next();
            boolean isNight = time.equals("NIGHT");
            Cab cab = switch (type) {
                case "MINI" -> new Mini(distance, isNight);
                case "SEDAN" -> new Sedan(distance, isNight);
                case "SUV" -> new SUV(distance, isNight);
                default -> null;
            };
            if (cab != null) {
                if (isNight && !cab.supportsNightService()) {
                    System.out.printf("%s: night service not available%n", cab.getType());
                } else {
                    double fare = cab.calculateFare();
                    total += fare;
                    System.out.printf("%s: %.2f%n", cab.getType(), fare);
                }
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}