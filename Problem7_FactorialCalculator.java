public class Problem7_FactorialCalculator {

    static class FactorialCalculator {
        public void calculate(int n) {
            long fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
            System.out.println(fact);
        }
    }

    public static void main(String[] args) {
        FactorialCalculator calc = new FactorialCalculator();
        calc.calculate(5);
        calc.calculate(0);
        System.out.println("---");
        calc.calculate(1);
        calc.calculate(10);
    }
}