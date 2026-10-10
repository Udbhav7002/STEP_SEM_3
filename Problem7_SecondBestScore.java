public class Problem7_SecondBestScore {

    static class SecondBestScore {
        public int secondHighest(int[] scores) {
            int highest = -1;
            int second = -1;
            for (int s : scores) {
                if (s > highest) {
                    second = highest;
                    highest = s;
                } else if (s < highest && s > second) {
                    second = s;
                }
            }
            return second;
        }
    }

    public static void main(String[] args) {
        SecondBestScore sbs = new SecondBestScore();
        System.out.println(sbs.secondHighest(new int[]{45, 78, 92, 78, 60})); // Expected: 78
        System.out.println(sbs.secondHighest(new int[]{50, 50, 50})); // Expected: -1
        System.out.println("---");
        System.out.println(sbs.secondHighest(new int[]{100, 90, 80, 70})); // Expected: 90
        System.out.println(sbs.secondHighest(new int[]{10, 20})); // Expected: 10
        System.out.println(sbs.secondHighest(new int[]{5})); // Expected: -1
        System.out.println(sbs.secondHighest(new int[]{10, 10, 20, 20, 30})); // Expected: 20
    }
}