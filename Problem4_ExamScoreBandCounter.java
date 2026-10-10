public class Problem4_ExamScoreBandCounter {

    static class ExamScoreBandCounter {
        public int countInBand(int[] scores, int low, int high) {
            int firstGeLow = lowerBound(scores, low);
            int firstGtHigh = upperBound(scores, high);
            return firstGtHigh - firstGeLow;
        }

        private int lowerBound(int[] arr, int target) {
            int lo = 0, hi = arr.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] < target) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }

        private int upperBound(int[] arr, int target) {
            int lo = 0, hi = arr.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] <= target) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }

    public static void main(String[] args) {
        ExamScoreBandCounter counter = new ExamScoreBandCounter();
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(counter.countInBand(scores, 42, 58)); // Expected: 6
        System.out.println(counter.countInBand(scores, 90, 100)); // Expected: 0
        System.out.println("---");
        System.out.println(counter.countInBand(scores, 35, 35)); // Expected: 1
        System.out.println(counter.countInBand(scores, 88, 88)); // Expected: 1
        System.out.println(counter.countInBand(scores, 0, 100)); // Expected: 10
    }
}