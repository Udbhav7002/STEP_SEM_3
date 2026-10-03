import java.util.Scanner;

public class Problem3_HostelElectricity {

    interface Room {
        double calculateBill();
        String getType();
    }

    static class SingleRoom implements Room {
        private final int units;
        public SingleRoom(int units) { this.units = units; }
        public double calculateBill() { return 8 * units; }
        public String getType() { return "SINGLE"; }
    }

    static class SharedRoom implements Room {
        private final int units, occupants;
        public SharedRoom(int units, int occupants) { this.units = units; this.occupants = occupants; }
        public double calculateBill() { return (6.0 * units) / occupants; }
        public String getType() { return "SHARED"; }
    }

    static class ACRoom implements Room {
        private final int units;
        public ACRoom(int units) { this.units = units; }
        public double calculateBill() { return 10 * units + 200; }
        public String getType() { return "AC"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            Room room = null;
            if (type.equals("SINGLE")) {
                int units = sc.nextInt();
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                int units = sc.nextInt();
                room = new ACRoom(units);
            }
            if (room != null) {
                double bill = room.calculateBill();
                total += bill;
                System.out.printf("%s: %.2f%n", room.getType(), bill);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}