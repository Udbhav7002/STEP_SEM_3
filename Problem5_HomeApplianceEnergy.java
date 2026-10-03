import java.util.Scanner;

public class Problem5_HomeApplianceEnergy {

    interface SaverMode {
        boolean supportsSaverMode();
    }

    abstract static class Appliance {
        protected final int hours;
        protected final boolean saver;
        protected static final double COST_PER_KWH = 8;
        public Appliance(int hours, boolean saver) { this.hours = hours; this.saver = saver; }
        public abstract double getPowerRating();
        public double calculateUnits() {
            double units = getPowerRating() * hours / 1000.0;
            if (saver && supportsSaverMode()) {
                units *= 0.75;
            }
            return units;
        }
        public double calculateCost() { return calculateUnits() * COST_PER_KWH; }
        public boolean supportsSaverMode() { return false; }
        public abstract String getType();
    }

    static class Fridge extends Appliance {
        public Fridge(int hours, boolean saver) { super(hours, saver); }
        public double getPowerRating() { return 150; }
        public String getType() { return "FRIDGE"; }
    }

    static class AC extends Appliance implements SaverMode {
        public AC(int hours, boolean saver) { super(hours, saver); }
        public double getPowerRating() { return 1500; }
        public boolean supportsSaverMode() { return true; }
        public String getType() { return "AC"; }
    }

    static class TV extends Appliance {
        public TV(int hours, boolean saver) { super(hours, saver); }
        public double getPowerRating() { return 100; }
        public String getType() { return "TV"; }
    }

    static class Washer extends Appliance implements SaverMode {
        public Washer(int hours, boolean saver) { super(hours, saver); }
        public double getPowerRating() { return 500; }
        public boolean supportsSaverMode() { return true; }
        public String getType() { return "WASHER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            Appliance app = switch (type) {
                case "FRIDGE" -> new Fridge(hours, saver);
                case "AC" -> new AC(hours, saver);
                case "TV" -> new TV(hours, saver);
                case "WASHER" -> new Washer(hours, saver);
                default -> null;
            };
            if (app != null) {
                if (saver && !app.supportsSaverMode()) {
                    System.out.printf("%s: saver mode not supported%n", app.getType());
                } else {
                    double units = app.calculateUnits();
                    double cost = app.calculateCost();
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getType(), units, cost);
                }
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}