public class Problem3_EvenOddCounter {

    static class EvenOddCounter {
        public void count(int[] numbers) {
            int even = 0, odd = 0;
            for (int n : numbers) {
                if (n % 2 == 0) even++;
                else odd++;
            }
            System.out.println("Even: " + even);
            System.out.println("Odd: " + odd);
        }
    }

    public static void main(String[] args) {
        EvenOddCounter counter = new EvenOddCounter();
        counter.count(new int[]{3, 8, 12, 5, 7, 10});
        System.out.println("---");
        counter.count(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}