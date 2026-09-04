public class P4_FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];

        for (char c : text.toCharArray()) {
            freq[c]++;
        }

        for (char c : text.toCharArray()) {
            if (freq[c] == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc", "hello", "programming", "a"};

        for (String input : inputs) {
            char result = findFirstNonRepeatingChar(input);
            if (result != '\0') {
                System.out.println("\"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + input + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}