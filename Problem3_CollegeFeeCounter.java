import java.util.Scanner;

public class Problem3_CollegeFeeCounter {

    interface BusUser {
        double getTransportFee();
    }

    abstract static class Student {
        protected final String name;
        protected static final double TRANSPORT_FEE = 12000;
        public Student(String name) { this.name = name; }
        public abstract double calculateTuition();
        public double calculateTotalFee() { return calculateTuition() + getTransportFee(); }
        public double getTransportFee() { return 0; }
        public String getName() { return name; }
    }

    static class DayScholar extends Student implements BusUser {
        public DayScholar(String name) { super(name); }
        public double calculateTuition() { return 40000; }
        public double getTransportFee() { return TRANSPORT_FEE; }
    }

    static class Hosteller extends Student {
        public Hosteller(String name) { super(name); }
        public double calculateTuition() { return 40000 + 60000; }
    }

    static class Scholar extends Student implements BusUser {
        public Scholar(String name) { super(name); }
        public double calculateTuition() { return 20000; }
        public double getTransportFee() { return TRANSPORT_FEE; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = switch (type) {
                case "DAY_SCHOLAR" -> new DayScholar(name);
                case "HOSTELLER" -> new Hosteller(name);
                case "SCHOLAR" -> new Scholar(name);
                default -> null;
            };
            if (student != null) {
                double fee = student.calculateTotalFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f%n", student.getName(), fee);
            }
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}