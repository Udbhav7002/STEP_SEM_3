import java.util.Scanner;

public class Problem2_WeeklyStaffPay {

    abstract static class StaffMember {
        protected final String name;
        public StaffMember(String name) { this.name = name; }
        public abstract double calculatePay();
        public String getName() { return name; }
    }

    static class FullTimeStaff extends StaffMember {
        private final double weeklySalary;
        public FullTimeStaff(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }
        public double calculatePay() { return weeklySalary; }
    }

    static class HourlyStaff extends StaffMember {
        private final int hours;
        private final double rate;
        public HourlyStaff(String name, int hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
        public double calculatePay() {
            if (hours <= 40) return hours * rate;
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends StaffMember {
        private final double stipend;
        public Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        public double calculatePay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalPay = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            StaffMember staff = null;
            if (type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                staff = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                int hours = sc.nextInt();
                double rate = sc.nextDouble();
                staff = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                double stipend = sc.nextDouble();
                staff = new Intern(name, stipend);
            }
            if (staff != null) {
                double pay = staff.calculatePay();
                totalPay += pay;
                System.out.printf("%s: %.2f%n", staff.getName(), pay);
            }
        }
        System.out.printf("Total Payroll: %.2f%n", totalPay);
        sc.close();
    }
}