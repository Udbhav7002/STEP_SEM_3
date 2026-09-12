import java.util.Locale;

public class Problem2_TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < total; i++) {
            if (i < typed.length() && original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = i < typed.length() ? typed.charAt(i) : ' ';
            }
        }

        double accuracy = total == 0 ? 100.0 : ((double) matched / total) * 100.0;
        String accStr = String.format(Locale.US, "%.2f%%", accuracy);

        if (firstMismatchPos == -1 && matched == total) {
            System.out.println("Matched: " + matched + "/" + total + " | Accuracy: " + accStr + " | No Mismatches");
        } else {
            System.out.println("Matched: " + matched + "/" + total + " | Accuracy: " + accStr +
                    " | First Mismatch at position " + firstMismatchPos + " ('" + origChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
