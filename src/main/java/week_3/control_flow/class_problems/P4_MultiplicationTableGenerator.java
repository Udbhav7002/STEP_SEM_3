public class P4_MultiplicationTableGenerator {
    public static void generateFirstValidTable(int[] candidates) {
        for (int candidate : candidates) {
            if (candidate < 1) {
                System.out.println("Skipping invalid number: " + candidate);
                continue;
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(candidate + " x " + i + " = " + (candidate * i));
            }
            break;
        }
    }

    public static void main(String[] args) {
        generateFirstValidTable(new int[]{-3, 0, 7, 9});
    }
}