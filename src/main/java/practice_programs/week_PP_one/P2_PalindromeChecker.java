public class P2_PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursiveHelper(cleaned, 0, cleaned.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        char[] chars = cleaned.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(chars).equals(new String(reversed));
    }

    public static void main(String[] args) {
        String[] inputs = {"madam", "hello", "A man a plan a canal Panama", "racecar"};

        for (String input : inputs) {
            boolean iterative = isPalindromeIterative(input);
            boolean recursive = isPalindromeRecursive(input);
            boolean arrayReversal = isPalindromeArrayReversal(input);

            System.out.println("\"" + input + "\"");
            System.out.println("Iterative: " + (iterative ? "Palindrome" : "Not Palindrome") + " | " +
                               "Recursive: " + (recursive ? "Palindrome" : "Not Palindrome") + " | " +
                               "Array Reversal: " + (arrayReversal ? "Palindrome" : "Not Palindrome"));
            System.out.println();
        }
    }
}