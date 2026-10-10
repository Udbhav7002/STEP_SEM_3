public class Problem1_VowelConsonantCounter {

    static class VowelConsonantCounter {
        public void count(String word) {
            int vowels = 0, consonants = 0;
            word = word.toLowerCase();
            for (char c : word.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }
            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
        }
    }

    public static void main(String[] args) {
        VowelConsonantCounter counter = new VowelConsonantCounter();
        counter.count("Programming");
        System.out.println("---");
        counter.count("Hello");
    }
}