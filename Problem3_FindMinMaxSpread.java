public class Problem3_FindMinMaxSpread {

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        
        for (int score : scores) {
            if (score < min) min = score;
            if (score > max) max = score;
        }
        
        return String.format("Min: %d | Max: %d | Spread: %d", min, max, max - min);
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
    }
}