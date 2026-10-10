public class Problem6_PrimeChecker {

    static class PrimeChecker {
        public void check(int number) {
            if (number <= 1) {
                System.out.println(number + " is not prime");
                return;
            }
            boolean isPrime = true;
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.println(number + (isPrime ? " is prime" : " is not prime"));
        }
    }

    public static void main(String[] args) {
        PrimeChecker checker = new PrimeChecker();
        checker.check(29);
        checker.check(21);
        System.out.println("---");
        checker.check(2);
        checker.check(1);
        checker.check(97);
        checker.check(100);
    }
}