public class Problem5_DigitSumReversal {

    static class DigitSumReversal {
        public void process(int number) {
            int original = number;
            int sum = 0;
            int reversed = 0;
            while (number > 0) {
                int digit = number % 10;
                sum += digit;
                reversed = reversed * 10 + digit;
                number /= 10;
            }
            System.out.println("Sum of digits: " + sum);
            System.out.println("Reverse: " + reversed);
        }
    }

    public static void main(String[] args) {
        DigitSumReversal dsr = new DigitSumReversal();
        dsr.process(4721);
        System.out.println("---");
        dsr.process(12345);
        System.out.println("---");
        dsr.process(1001);
    }
}