import java.util.Scanner;

public class Problem5_TransportFare {

    interface Transport {
        double calculateFare();
        String getType();
    }

    static class Bus implements Transport {
        private final double distance;
        public Bus(double distance) { this.distance = distance; }
        public double calculateFare() { return Math.min(2 + 0.10 * distance, 10); }
        public String getType() { return "BUS"; }
    }

    static class Train implements Transport {
        private final double distance;
        public Train(double distance) { this.distance = distance; }
        public double calculateFare() { return 3 + 0.15 * distance; }
        public String getType() { return "TRAIN"; }
    }

    static class Metro implements Transport {
        private final double distance, peakFactor;
        public Metro(double distance, double peakFactor) { this.distance = distance; this.peakFactor = peakFactor; }
        public double calculateFare() { return (1.50 + 0.20 * distance) * peakFactor; }
        public String getType() { return "METRO"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t = null;
            if (type.equals("BUS")) {
                t = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                t = new Train(distance);
            } else if (type.equals("METRO")) {
                double peakFactor = sc.nextDouble();
                t = new Metro(distance, peakFactor);
            }
            if (t != null) {
                double fare = t.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f%n", t.getType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}