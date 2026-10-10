public class Problem2_WordReverserPalindrome {

    static class WordReverserPalindrome {
        public void check(String word) {
            StringBuilder sb = new StringBuilder(word);
            String reversed = sb.reverse().toString();
            boolean isPalindrome = word.equalsIgnoreCase(reversed);
            System.out.println(reversed + " - " + (isPalindrome ? "palindrome" : "not a palindrome"));
        }
    }

    public static void main(String[] args) {
        WordReverserPalindrome wp = new WordReverserPalindrome();
        wp.check("level");
        wp.check("java");
        System.out.println("---");
        wp.check("Radar");
        wp.check("Test");
    }
}