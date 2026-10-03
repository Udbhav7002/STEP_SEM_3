import java.util.Scanner;

public class Problem4_FestivalBonus {

    interface Employee {
        double calculateBonus();
        String getName();
    }

    static class FullTime implements Employee {
        private final String name;
        private final double salary;
        public FullTime(String name, double salary) { this.name = name; this.salary = salary; }
        public double calculateBonus() { return salary * 0.10; }
        public String getName() { return name; }
    }

    static class PartTime implements Employee {
        private final String name;
        private final double salary;
        public PartTime(String name, double salary) { this.name = name; this.salary = salary; }
        public double calculateBonus() { return salary * 0.05; }
        public String getName() { return name; }
    }

    static class Intern implements Employee {
        private final String name;
        public Intern(String name, double salary) { this.name = name; }
        public double calculateBonus() { return 2000; }
        public String getName() { return name; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee emp = switch (type) {
                case "FULLTIME" -> new FullTime(name, salary);
                case "PARTTIME" -> new PartTime(name, salary);
                case "INTERN" -> new Intern(name, salary);
                default -> null;
            };
            if (emp != null) {
                double bonus = emp.calculateBonus();
                total += bonus;
                System.out.printf("%s: %.2f%n", emp.getName(), bonus);
            }
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}